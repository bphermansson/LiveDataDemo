package nu.paheco.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    var counter: MutableLiveData<Int> = MutableLiveData(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = findViewById<Button>(R.id.btn)
        var cnt = findViewById<TextView>(R.id.counterTV)

        counter.observe(this, Observer {
            cnt.text  = counter.value.toString()
        })

        btn.setOnClickListener {
            counter.value?.let {
                counter.value = it + 1
            }
        }
    }
}