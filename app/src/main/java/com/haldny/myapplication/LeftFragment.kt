package com.haldny.myapplication

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class LeftFragment : Fragment() {

    private var lvAnimais: ListView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedIntanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.left_fragment, null)

        lvAnimais = view.findViewById<View>(R.id.lvAnimais) as ListView

        lvAnimais?.onItemClickListener =
            OnItemClickListener { _, _, position, _ -> tratarSelecao(position) }
        return view
    } //fim do método onCreateView

    protected fun tratarSelecao(position: Int) {
        val descricao = lvAnimais?.getItemAtPosition(position).toString()
        val fm = parentFragmentManager

        val configuration = resources.configuration

        when (configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                val rf: RightFragment = fm.findFragmentById(R.id.rightFragment) as RightFragment
                rf.setConteudo(position, descricao)
            }
            Configuration.ORIENTATION_PORTRAIT -> {
                val rf = RightFragment()

                val args = Bundle()
                args.putInt("pos", position)
                args.putString("descricao", descricao)
                rf.setArguments(args)

                val fragmentTransaction: FragmentTransaction = fm.beginTransaction()

                fragmentTransaction.replace(R.id.container, rf)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }

    } //fim do método tratarSelecao

} //fim da classe LeftFragment
