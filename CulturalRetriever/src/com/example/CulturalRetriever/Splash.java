package com.example.CulturalRetriever;

import com.example.CulturalRetriever.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{
	MediaPlayer introSong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		/**
		 * setting up media
		 */
		introSong = MediaPlayer.create(Splash.this, R.raw.beastie_boys_ch_check_it_out);
		introSong.start();
        /**
         * set up for required splash activity
         */
        Thread introduction = new Thread(){
        	public void run(){
        		try{
        			sleep(1000); //62000
        		}catch(InterruptedException ex){
        			ex.printStackTrace();
        		}finally{
        			Intent openSplash = new Intent("com.example.helloworld.MAINACTIVITY");
        			startActivity(openSplash);
        			
        		}
        	}
        };
       
        introduction.start();
	}
	@Override
	protected void onPause(){
		introSong.release();
		super.onPause();
		//end splash
		finish();
	}
}
	