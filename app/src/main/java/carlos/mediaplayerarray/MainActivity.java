package carlos.mediaplayerarray;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity{
    MediaPlayer mediaPlayer;
    TextView tvSong;
    ImageButton btnPlay;
    ArrayList<Song> songsList;
    ImageView ivSongCover;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pos = 0;
        tvSong = (TextView)findViewById(R.id.tvSong);
        btnPlay = (ImageButton)findViewById(R.id.btnPlay);
        ivSongCover = (ImageView)findViewById(R.id.ivSongCover);
        loadSongs();

        mediaPlayer = MediaPlayer.create(this, songsList.get(pos).getId());
        loadInfo(pos);



        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Check next
                mediaPlayer.release();
                System.out.println("song ended");
            }
        });
    }

    /**
     * Action for Play/Pause button
     * @param view
     */
    public void play(View view){
        if(mediaPlayer.isPlaying()){
            try{
                mediaPlayer.pause();
                btnPlay.setImageResource(R.drawable.ic_action_play);
            }catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Error while trying to pause.");
            }

        }else{
            try{
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.ic_action_pause);
            }catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Error while trying to play.");
            }
        }
    }

    /**
     * Action for Next Button
     * @param view
     */
    public void next(View view){
        boolean isp = mediaPlayer.isPlaying();


        if(pos<songsList.size()-1){
            pos++;
        }else{
            pos=0;
        }

        System.out.println("pos: "+pos+" size: "+songsList.size());
        mediaPlayer.release();
        mediaPlayer = MediaPlayer.create(this, songsList.get(pos).getId());
        loadInfo(pos);

        if (isp){
            mediaPlayer.start();
        }
    }

    /**
     * Action for Previous Button
     * @param view
     */
    public void prev(View view){
        boolean isp = mediaPlayer.isPlaying();
        if(pos>0){
            pos--;
        }else{
            pos=songsList.size()-1;
        }
        mediaPlayer.release();
        mediaPlayer = MediaPlayer.create(this, songsList.get(pos).getId());
        loadInfo(pos);

        if (isp){
            mediaPlayer.start();
        }
    }

    /**
     * Creates track list
     */
    public void loadSongs(){
        songsList = new ArrayList();
        songsList.add(new Song(R.raw.titanic,"titanic", "My heart will go on","Titanic Soundtrack", R.drawable.titanic));
        songsList.add(new Song(R.raw.badboy,"badboy", "Bad Boy","Andy Salad", R.drawable.badboy));
        songsList.add(new Song(R.raw.rtz,"rtz", "rtz ti5","Andy Salad", R.drawable.rtz));
        songsList.add(new Song(R.raw.cocojambo,"cocojambo", "Coco Jambo","K Ronaldo", R.drawable.cocojambo));
        songsList.add(new Song(R.raw.mangobay,"mangobay", "Mango Bay","Coast", R.drawable.mangobay));
    }

    /**
     * Load track info to the view.
     * @param pos
     */
    public void loadInfo(int pos){
        tvSong.setText(songsList.get(pos).getArtist()+" - "+songsList.get(pos).getTitle());
        ivSongCover.setImageResource(songsList.get(pos).getIdimg());
    }
}
