package ru.lachesis.imagetransform.presentation

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lachesis.imagetransform.R
import ru.lachesis.imagetransform.SchedulersFactory
import ru.lachesis.imagetransform.data.Image
import ru.lachesis.imagetransform.data.RepositoryFactory
import ru.lachesis.imagetransform.databinding.ConvertViewBinding

class MainFragment : MvpAppCompatFragment(R.layout.convert_view), MainView {

    private val binding: ConvertViewBinding by viewBinding()
    private val repo by lazy { RepositoryFactory.create(requireContext()) }
    private val schedulers = SchedulersFactory.create()
    private var requestCode = 1

    private val presenter by moxyPresenter {
        MainPresenter(
            repository = repo,
            schedulers = schedulers
        )
    }

    companion object {
        fun newInstance(): Fragment = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.convertButton.setOnClickListener{v->pickImage()}
    }

    fun pickImage() {
        val imagePickerIntent = Intent(Intent.ACTION_GET_CONTENT)
        imagePickerIntent.setType("image/*");

        startActivityForResult(imagePickerIntent, requestCode);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val image = data?.data?.let { Image(it) }
            image?.let { presenter.convert(it) }

        } else {
            Toast.makeText(requireActivity(),"Изображение не выбрано",Toast.LENGTH_LONG).show()
        }
    //    override fun convert(image: Image){

    }

    /*   override fun ShowError() {
           presenter.showError()
       }

       override fun showLoading() {
           presenter.showLoading()    }
   */
}