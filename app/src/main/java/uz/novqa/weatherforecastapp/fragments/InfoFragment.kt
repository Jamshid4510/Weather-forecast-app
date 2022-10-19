package uz.novqa.weatherforecastapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_info.view.*
import uz.novqa.weatherforecastapp.R
import uz.novqa.weatherforecastapp.adapters.NextForecastAdapter
import uz.novqa.weatherforecastapp.adapters.TodayForecastAdapter
import uz.novqa.weatherforecastapp.models.NextDaysWeather
import uz.novqa.weatherforecastapp.models.TodayWeather
import kotlin.random.Random
import kotlin.random.nextInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InfoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var root: View
    lateinit var todayForecastAdapter: TodayForecastAdapter
    lateinit var listForTodayForecast: ArrayList<TodayWeather>

    lateinit var nextForecastAdapter: NextForecastAdapter
    lateinit var listForNextForecast: ArrayList<NextDaysWeather>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_info, container, false)

        loadDataForTodayWeather()
        loadDataForNexDaysWeather()

        todayForecastAdapter = TodayForecastAdapter(listForTodayForecast)
        root.rv_today.adapter = todayForecastAdapter

        nextForecastAdapter = NextForecastAdapter(listForNextForecast)
        root.rv_next_days.adapter = nextForecastAdapter

        root.img_back.setOnClickListener {
            root.findNavController().navigate(R.id.homeFragment)
        }

        root.tv_back.setOnClickListener {
            root.findNavController().navigate(R.id.homeFragment)
        }

        return root
    }

    private fun loadDataForTodayWeather(){
        listForTodayForecast = arrayListOf()
        var time: Int = 4

        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        time = 0
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time ++}:00"))
        listForTodayForecast.add(TodayWeather(Random.nextInt(0..40), R.drawable.cloudy, "${time}:00"))
    }

    private fun loadDataForNexDaysWeather(){
        listForNextForecast = arrayListOf()

        for (i in 1..30){
            listForNextForecast.add(NextDaysWeather("Sep, $i", R.drawable.cloudy, Random.nextInt(0..40)))
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}