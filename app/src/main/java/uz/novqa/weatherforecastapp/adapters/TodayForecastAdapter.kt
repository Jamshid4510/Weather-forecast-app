package uz.novqa.weatherforecastapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_today.view.*
import uz.novqa.weatherforecastapp.R
import uz.novqa.weatherforecastapp.models.TodayWeather

class TodayForecastAdapter(var list: ArrayList<TodayWeather>) : RecyclerView.Adapter<TodayForecastAdapter.Vh>() {
    inner class Vh(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun onBind(todayWeather: TodayWeather){
            itemView.tv_item_degree.text = todayWeather.degree.toString()
            itemView.img_item_condition.setBackgroundResource(todayWeather.img_condition)
            itemView.tv_item_time.text = todayWeather.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_today, parent, false)

        return Vh(itemView)
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}