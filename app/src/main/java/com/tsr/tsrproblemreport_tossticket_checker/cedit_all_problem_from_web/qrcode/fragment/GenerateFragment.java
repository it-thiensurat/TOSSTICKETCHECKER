package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.data.constant.Constants;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.utility.AppUtils;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.utility.CodeGenerator;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.utility.SaveImage;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.utility.Util;

import java.io.InputStream;

import static android.app.Activity.RESULT_OK;


public class GenerateFragment extends Fragment {

    private Activity mActivity;
    private Context mContext;

    private EditText inputText;
    private ImageView outputBitmap;
            //img_profile;
    private ImageButton switcher;
    private FloatingActionButton save, share;
    Button btn_logo;

    private static final int TYPE_QR = 0, TYPE_BAR = 1;
    private static int TYPE = TYPE_QR;

    private Bitmap output;
    private String inputStr;
    private Bitmap bitmap_qr;
    private Bitmap bitmap_logo = null;
    private static final int PICK_CONTACT    = 100;
    private static final int PICK_IMAGE = 1;
    private static final int QR_SIZE = 512;
    private static final int LOGO_SIZE = 90;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_generate, container, false);


        initView(rootView);
        initFunctionality();
        initListener();

        return rootView;
    }

    private void initVar() {
        mActivity = getActivity();
        mContext = mActivity.getApplicationContext();


    }

    private void initView(View rootView) {
       // img_profile  = (ImageView)rootView.findViewById(R.id.img_profile);

        inputText = (EditText) rootView.findViewById(R.id.inputText);
        outputBitmap = (ImageView) rootView.findViewById(R.id.outputBitmap);
        switcher = (ImageButton) rootView.findViewById(R.id.switcher);
        save = (FloatingActionButton) rootView.findViewById(R.id.save);
        share = (FloatingActionButton) rootView.findViewById(R.id.share);

        save.hide();
        share.hide();






    }

    private void initFunctionality() {


    }

    private void initListener() {
        inputText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0) {
                    generateCode(Util.gen_qr_text("0929056128", s.toString()));
                } else {
                    save.hide();
                    share.hide();
                    if(TYPE == TYPE_QR) {
                        outputBitmap.setImageResource(R.drawable.ic_qr_placeholder);
                      //  img_profile.setVisibility(View.GONE);
                    } else {
                        outputBitmap.setImageResource(R.drawable.ic_bar_placeholder);
                    }
                }
            }
        });

        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputText.setText("");
                save.hide();
                share.hide();
                if(TYPE == TYPE_QR) {
                    TYPE = TYPE_BAR;
                    switcher.setImageResource(R.drawable.ic_qr_button);
                    inputText.setHint(R.string.type_here_bar);
                    outputBitmap.setImageResource(R.drawable.ic_bar_placeholder);
                } else {
                    TYPE = TYPE_QR;
                    switcher.setImageResource(R.drawable.ic_barcode_button);
                    inputText.setHint(R.string.type_here_qr);
                    outputBitmap.setImageResource(R.drawable.ic_qr_placeholder);
                    //img_profile.setVisibility(View.GONE);
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAndShare(false, inputStr, output);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAndShare(true, inputStr, output);
            }
        });

    }

    private void generateCode(final String input) {
        CodeGenerator codeGenerator = new CodeGenerator();
        if(TYPE == TYPE_BAR) {
            codeGenerator.generateBarFor(input);
        } else {
            codeGenerator.generateQRFor(input);
        }
        codeGenerator.setResultListener(new CodeGenerator.ResultListener() {
            @Override
            public void onResult(Bitmap bitmap) {
                //((BitmapDrawable)outputBitmap.getDrawable()).getBitmap().recycle();
                output = bitmap;
                inputStr = input;


                String remark ="เลขที่สัญญา A1234";


                if(!remark.isEmpty()){
                    output = Util.drawTextToBitmap(getActivity(), output, remark);
                }

                Drawable myDrawable = getResources().getDrawable(R.drawable.ic_launcher_test);
                Bitmap bitmap_logo = ((BitmapDrawable) myDrawable).getBitmap();
                bitmap_logo = Util.resize_bitmap(bitmap_logo, LOGO_SIZE);
                // render logo
                if(bitmap_logo != null){
                    Canvas canvas_qr = new Canvas(output);
                    Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
                    int logo_x = (QR_SIZE-bitmap_logo.getWidth())/2;
                    int logo_y = (QR_SIZE-bitmap_logo.getHeight())/2;
                    //canvas_qr.drawBitmap(bitmap_logo, logo_x, logo_y, paint);
                    canvas_qr.drawBitmap(bitmap_logo, 512, 512, paint);
                   // btn_logo.setText("ลบโลโก้");



                }





                outputBitmap.setImageBitmap(output);



               // img_profile.setVisibility(View.VISIBLE);
                if(!save.isShown()) {
                    save.show();
                    share.show();
                }
            }
        });
        codeGenerator.execute();
    }

    private void saveAndShare(final boolean shouldShare, String name, Bitmap bitmap) {

        if(shouldShare) {
            AppUtils.showToast(mContext, getString(R.string.preparing));
        } else {
            AppUtils.showToast(mContext, getString(R.string.saving));
        }
        SaveImage saveImage = new SaveImage(name, bitmap);
        saveImage.setSaveListener(new SaveImage.SaveListener() {
            @Override
            public void onSaved(String savedTo) {

                if (shouldShare) {
                    AppUtils.shareImage(mActivity, savedTo);
                } else {
                    AppUtils.showToast(mContext, getString(R.string.saved_to) +"'"+ Constants.SAVE_TO +"' "+getString(R.string.directory_in));
                }
            }
        });
        saveImage.execute();
    }


    @Override
    public void onPause() {
        super.onPause();



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == PICK_IMAGE){
            if((data != null)&&(data.getData() != null)){
                try {
                    InputStream imageStream = getActivity().getContentResolver().openInputStream(data.getData());
                    bitmap_logo = BitmapFactory.decodeStream(imageStream);
                    bitmap_logo = Util.resize_bitmap(bitmap_logo, LOGO_SIZE);
                    initListener();
                }
                catch(Exception e){
                  //  Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                  //  Log.e(TAG, e.getStackTrace().toString());
                }
            }
            else {
               // Toast.makeText(this, "ไม่พบโลโก้ของคุณ กรุณาลองใหม่อีกครั้ง", Toast.LENGTH_LONG).show();
            }
        }
        // set telephone number from contact list
        else if((resultCode == RESULT_OK) && (requestCode == PICK_CONTACT)){
            //Util.getTelNoFromContacts(GenerateFragment.this, getActivity().getContentResolver(), data, inputText);
        }



    }
}
