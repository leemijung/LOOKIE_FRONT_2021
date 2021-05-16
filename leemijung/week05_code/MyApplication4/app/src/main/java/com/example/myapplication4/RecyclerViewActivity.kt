package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)


        val carlist=ArrayList<Car>()
        for( i in 0 until 10){
            carlist.add(Car(""+i+"번째 자동차", ""+i+"순위 엔진"))
        }

        val adapter=RecyclerViewAdapter(carlist, LayoutInflater.from(this@RecyclerViewActivity))
        recycler_view.adapter=adapter

        recycler_view.layoutManager=LinearLayoutManager(this@RecyclerViewActivity) //수직/수평
        //recycler_view.layoutManager=GridLayoutManager(this@RecyclerViewActivity, 2) //바둑판
    }
}

class RecyclerViewAdapter(
    val itemList:ArrayList<Car>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val carName:TextView
        val carEngine:TextView
        init{
            carName=itemView.findViewById(R.id.car_name)
            carEngine=itemView.findViewById(R.id.car_engine)

            itemView.setOnClickListener{
                val position : Int = adapterPosition //포지션 호출변수
                val engineName=itemList.get(position).engine
                Log.d("engine", engineName)
            }
        }
    }

    //뷰 만들기
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    //뷰 그리기
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}