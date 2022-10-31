package uz.bdm.podcast.screen.player

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import uz.bdm.podcast.utils.Constants
import uz.bdm.podcast.utils.PrefUtils
import uz.bdm.podcast.R
import uz.bdm.podcast.adapter.EpisodeAdapter
import uz.bdm.podcast.databinding.ActivityPlayerBinding
import uz.bdm.podcast.model.PodcastModel

class PlayerActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlayerBinding

    lateinit var item: PodcastModel
    lateinit var mediaPlayer:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        item = intent.getSerializableExtra(Constants.EXTRA_DATA) as PodcastModel

        binding.tvEpisodesCount.text = "Episodes (${PrefUtils.getPodcasts()?.size ?: 0})"
        mediaPlayer = MediaPlayer.create(this, item.trackSrc)
        mediaPlayer.start()
        val time = mediaPlayer.duration

        binding.imgBack.setOnClickListener {
            finish()
            mediaPlayer.pause()
        }
        binding.seekBar.progress=0
        binding.seekBar.max=mediaPlayer.duration

        binding.seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2){
                    mediaPlayer.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        binding.cardPause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                binding.imgPause.setImageResource(R.drawable.ic_outline_play_arrow_24)
            } else {
                mediaPlayer.start()
                binding.imgPause.setImageResource(R.drawable.ic_baseline_pause_24)
                binding.imgPause.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
        }


      //  binding.tvDuration.text = setTime(time)
        binding.recyclerEpisodes.layoutManager = LinearLayoutManager(this)
        binding.recyclerEpisodes.adapter = EpisodeAdapter(PrefUtils.getPodcasts() ?: arrayListOf())
        Thread(Runnable {
            while (mediaPlayer!=null){
                try {
                    val msg= Message()
                    msg.what=mediaPlayer.currentPosition
                    click.sendMessage(msg)
                    Thread.sleep(1000)
                } catch (e:InterruptedException){

                }
            }
        }).start()
    }

    @SuppressLint("HandlerLeak")
    var click = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val currentPosition = msg.what
            binding.seekBar.progress = currentPosition
            val elapsedTime = createTimeLabel(currentPosition)
            binding.tvStartTime.text = elapsedTime
            val endTime = createTimeLabel(mediaPlayer.duration-currentPosition)
            binding.tvEndTime.text="-$endTime"
        }
    }
    fun createTimeLabel(time: Int): String {
        var timeLabel = ""
        val min = time / 1000 / 60
        val sec = time / 1000 % 60

        timeLabel = "$min:"
        if (sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
    }


}