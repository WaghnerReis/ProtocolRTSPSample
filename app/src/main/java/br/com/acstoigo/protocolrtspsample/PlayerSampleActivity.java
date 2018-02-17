package br.com.acstoigo.protocolrtspsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pedro.vlc.VlcListener;
import com.pedro.vlc.VlcVideoLibrary;

import br.com.acstoigo.protocolrtspsample.databinding.ActivityPlayerSampleBinding;

public class PlayerSampleActivity extends AppCompatActivity implements VlcListener {

    private ActivityPlayerSampleBinding mBinding;

    private VlcVideoLibrary mVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_player_sample);
        mVideo = new VlcVideoLibrary(this, this, mBinding.player);

        startStream();
    }

    private void startStream() {
        String rtspAddress = getString(R.string.rtsp_address);
        if (!mVideo.isPlaying()) mVideo.play(rtspAddress);
    }

    @Override
    public void onComplete() {
        mBinding.load.setVisibility(View.GONE);
    }

    @Override
    public void onError() {

    }
}