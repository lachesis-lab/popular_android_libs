package ru.gb.gb_popular_libs.lession1

class Presenter(
    private val view: IView,
    private val model: Model) {
    interface IView{
        fun showCounter(id: Int)
    }
    fun initViews(){
        model.set(0,0)
        model.set(1,0)
        model.set(2,0)
    }

    fun counterNext(id: Int): Int{
        return model.next(id)
    }


}