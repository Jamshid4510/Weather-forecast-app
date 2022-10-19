package uz.novqa.weatherforecastapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_next_days.view.*
import uz.novqa.weatherforecastapp.R
import uz.novqa.weatherforecastapp.models.NextDaysWeather

class NextForecastAdapter (var list: ArrayList<NextDaysWeather>) : RecyclerView.Adapter<NextForecastAdapter.Vh>() {
    inner class Vh(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun onBind(nextDaysWeather: NextDaysWeather){
            itemView.tv_data.text = nextDaysWeather.data
            itemView.img_condition.setBackgroundResource(nextDaysWeather.img_condition)
            itemView.tv_degree.text = nextDaysWeather.degree.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_next_days, parent, false)

        return Vh(itemView)
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}