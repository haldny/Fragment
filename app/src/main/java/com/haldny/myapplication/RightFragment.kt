package com.haldny.myapplication

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class RightFragment : Fragment() {

    private val imagens_id = intArrayOf(
        R.drawable.curucaca,
        R.drawable.gralhaazul,
        R.drawable.graxaim,
        R.drawable.ourico,
        R.drawable.queroquero
    )

    private var imAnimal: ImageView? = null
    private var tvDescricao: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedIntanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.right_fragment, null)

        imAnimal = view.findViewById<View>(R.id.imAnimal) as ImageView
        tvDescricao = view.findViewById<View>(R.id.tvDescricao) as TextView

        imAnimal?.scaleType = ImageView.ScaleType.FIT_XY

        val b = this.arguments

        if (b != null) {
            val pos = b.getInt("pos")
            val descricao = b.getString("descricao")
            setConteudo(pos, descricao)
        }

        return view
    } //fim do método onCreateView

    fun setConteudo(pos: Int, descricao: String?) {
        imAnimal?.setImageResource(imagens_id[pos])
        tvDescricao?.text = descricao
    } //fim do método setConteudo

} //fim da classe RightFragment
