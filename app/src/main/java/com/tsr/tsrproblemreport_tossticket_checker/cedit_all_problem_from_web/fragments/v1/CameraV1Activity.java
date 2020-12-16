package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments.v1;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.MediaActionSound;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.TextureView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;


import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.utils.ImageConfiguration;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Akexorcist on 7/28/2017 AD.
 */

public class CameraV1Activity extends AppCompatActivity implements TextureView.SurfaceTextureListener {
    private static final String TAG = CameraV1Activity.class.getSimpleName();

    private int cameraId = Camera.CameraInfo.CAMERA_FACING_BACK;

    private Button buttonCapture;
    private Button buttonFocus;
    private ToggleButton toggleButtonFlash;
    private TextureView textureViewCamera;
    String PATH;
    private Camera camera;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_v1);

        buttonCapture = findViewById(R.id.buttonCapture);
        buttonFocus = findViewById(R.id.buttonFocus);
        toggleButtonFlash = findViewById(R.id.toggleButtonFlash);
        textureViewCamera = findViewById(R.id.textureViewCamera);

        buttonCapture.setOnClickListener(view -> takePicture());
        buttonFocus.setOnClickListener(view -> refocus());
        toggleButtonFlash.setOnCheckedChangeListener((buttonView, isChecked) -> toggleNegativeColor(isChecked));
        textureViewCamera.setSurfaceTextureListener(this);

        PackageManager m = getPackageManager();
        PATH = getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(PATH, 0);
            PATH = p.applicationInfo.dataDir;
            Log.e("app path", PATH);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (textureViewCamera.isAvailable()) {
            setupCamera(textureViewCamera.getWidth(), textureViewCamera.getHeight());
            startCameraPreview(textureViewCamera.getSurfaceTexture());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopCamera();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textureViewCamera.setSurfaceTextureListener(null);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        setupCamera(width, height);
        startCameraPreview(surfaceTexture);
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        stopCamera();
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private void setupCamera(int width, int height) {
        camera = CameraV1Util.openCamera(cameraId);
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size bestPreviewSize = CameraV1Util.getBestPreviewSize(parameters.getSupportedPreviewSizes(), width, height);
        parameters.setPreviewSize(bestPreviewSize.width, bestPreviewSize.height);
        Camera.Size bestPictureSize = CameraV1Util.getBestPictureSize(parameters.getSupportedPictureSizes());
        parameters.setPictureSize(bestPictureSize.width, bestPictureSize.height);
        if (CameraV1Util.isContinuousFocusModeSupported(parameters.getSupportedFocusModes())) {
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
        }
        camera.setParameters(parameters);
        camera.setDisplayOrientation(CameraV1Util.getCameraDisplayOrientation(this, cameraId));
        textureViewCamera.setTransform(CameraV1Util.getCropCenterScaleMatrix(width, height, bestPreviewSize.width, bestPreviewSize.height));
    }

    private void startCameraPreview(SurfaceTexture surfaceTexture) {
        try {
            camera.setPreviewTexture(surfaceTexture);
            camera.startPreview();
        } catch (IOException e) {
            Log.e(TAG, "Error start camera preview: " + e.getMessage());
        }
    }

    private void stopCamera() {
        try {
            camera.stopPreview();
            camera.release();
        } catch (Exception e) {
            Log.e(TAG, "Error stop camera preview: " + e.getMessage());
        }
    }
    ImageConfiguration ic;
    Uri fileUri;
    Intent CamIntent,CropIntent;
    File file2;
    private void takePicture() {
        camera.takePicture(this::playShutterSound,
                null,
                null,
                (data, camera) -> {

                    ic = new ImageConfiguration(this,PATH);
                    file2 = ic.createImageByType_error(MyApplication.getInstance().getPrefManager().getPreferrence("contno_save"),
                            "report_problem", "ALL");
                    //fileUri = Uri.fromFile(file);
                    //CamIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

                   // File file = CameraV1Util.savePicture(file2);
                    int orientation = CameraV1Util.getCameraDisplayOrientation(this, cameraId);
                    CameraV1Util.setImageOrientation(file2, orientation);
                    CameraV1Util.updateMediaScanner(this, file2);
                });

    }

    private void refocus() {
        camera.autoFocus((success, camera) -> playFocusSound());
    }

    private void toggleNegativeColor(boolean isTurnOn) {
        Camera.Parameters parameters = camera.getParameters();
        List<String> supportedColorEffectList = parameters.getSupportedColorEffects();
        if (supportedColorEffectList != null && supportedColorEffectList.contains(Camera.Parameters.EFFECT_NEGATIVE)) {
            if (isTurnOn) {
                parameters.setColorEffect(Camera.Parameters.EFFECT_NEGATIVE);
            } else {
                parameters.setColorEffect(Camera.Parameters.EFFECT_NONE);
            }
        } else {
            Toast.makeText(this, "sss", Toast.LENGTH_SHORT).show();
        }
        camera.setParameters(parameters);
    }

    private void playShutterSound() {
        MediaActionSound sound = new MediaActionSound();
        sound.play(MediaActionSound.SHUTTER_CLICK);
    }

    private void playFocusSound() {
        MediaActionSound sound = new MediaActionSound();
        sound.play(MediaActionSound.FOCUS_COMPLETE);
    }
}
