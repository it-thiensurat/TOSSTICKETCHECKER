package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.fragments;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.github.zagum.speechrecognitionview.RecognitionProgressView;
import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters.RecyclerViewAdapterCheckBox_modify;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetDataAdapterCheckBox_modify;
import com.tsr.tsrproblemreport_tossticket_checker.other_all.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class UI_CARDVIEW_DATA_CEDIT_modify_problem1 extends Fragment  implements View.OnClickListener {



    List<GetDataAdapterCheckBox_modify> GetDataAdapter1;
    String GET_JSON_DATA_HTTP_URL = "http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/groud_problem_genaral.php";
    String GET_insent_report_problem="http://app.thiensurat.co.th/assanee/api_cedit_all_problem_from_web/insert_report_problem.php";

    RecyclerViewAdapterCheckBox_modify recyclerViewadapter1;
    String JSON_ID = "id_ge";
    String JSON_PROBLEM = "topic_problem_ge";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    JsonArrayRequest jsonArrayRequest ;
    RequestQueue requestQueue ;
    RelativeLayout relativeLayout;
    SwipeRefreshLayout swipeRefreshLayout;
    FloatingActionButton floatingActionButton;

    StringBuilder stringBuilder,stringBuilder2,stringBuilder3,stringBuilder4;
    String DADA,DADA2,DADA3;
    StringBuilder kaka;

    String Description="";

    private SpeechRecognizer speechRecognizer;
    RecognitionProgressView recognitionProgressView;
    Intent intent;
    private boolean mIslistening;
    ImageView on_mic;
    private static final int REQUEST_RECORD_AUDIO_PERMISSION_CODE = 1;

    public  static boolean open_mic = false;
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);

        recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(recyclerViewlayoutManager);





        // recognitionProgressView ******************************
        int[] colors = {
                ContextCompat.getColor(getActivity(), R.color.color1),
                ContextCompat.getColor(getActivity(), R.color.color2),
                ContextCompat.getColor(getActivity(), R.color.color3),
                ContextCompat.getColor(getActivity(), R.color.color4),
                ContextCompat.getColor(getActivity(), R.color.color5)
        };

//    int[] heights = { 20, 24, 18, 23, 16 };
        int[] heights = {60, 76, 58, 80, 55};
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(getActivity());


        recognitionProgressView.setSpeechRecognizer(speechRecognizer);
        // recognitionProgressView ******************************
        startRecognition();
        recognitionProgressView.setColors(colors);
        recognitionProgressView.setBarMaxHeightsInDp(heights);
        recognitionProgressView.setCircleRadiusInDp(2);
        recognitionProgressView.setSpacingInDp(2);
        recognitionProgressView.setIdleStateAmplitudeInDp(2);
        recognitionProgressView.setRotationRadiusInDp(10);
        recognitionProgressView.play();








        JSON_DATA_WEB_CALL();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                recyclerView.setHasFixedSize(true);

                recyclerViewlayoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(recyclerViewlayoutManager);
                GetDataAdapter1.clear();
                JSON_DATA_WEB_CALL();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layoutView = inflater.inflate(R.layout.cardview_row_cedit_cedit, container, false);

        setHasOptionsMenu(true);



        GetDataAdapter1 = new ArrayList<>();

        recyclerView = (RecyclerView) layoutView.findViewById(R.id.recyclerview1);
        relativeLayout= (RelativeLayout) layoutView.findViewById(R.id.relativeLayout);
        swipeRefreshLayout = (SwipeRefreshLayout) layoutView.findViewById(R.id.swipe_refresh_layout);
        floatingActionButton= (FloatingActionButton) layoutView.findViewById(R.id.fab);
        recognitionProgressView = (RecognitionProgressView) layoutView.findViewById(R.id.recognition_view);
        on_mic= (ImageView) layoutView.findViewById(R.id.on_mic);






        relativeLayout.setVisibility(View.GONE);
        floatingActionButton.setOnClickListener(this);




        on_mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  startRecognition();
                if(!open_mic){
                    open_mic=true;
                    on_mic.setBackgroundResource(R.drawable.ic_mic_white_24dp);
                    //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //    on_mic.setBackgroundTintList(ColorStateList.valueOf(0xff3164d7));
                    // }
                }
                else {
                    open_mic=false;
                    on_mic.setBackgroundResource(R.drawable.ic_mic_off_white_24dp);
                    //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //     on_mic.setBackgroundTintList(ColorStateList.valueOf(0xffffffff));
                    // }
                }


                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.RECORD_AUDIO)
                        != PackageManager.PERMISSION_GRANTED) {

                    requestPermission();
                } else {

                    startRecognition();


                    recognitionProgressView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startRecognition();

                        }
                    }, 50);

                }



            }
        });




        return layoutView;

    }
    private void startRecognition() {
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getActivity().getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "th");

        SpeechRecognitionListener speechRecognitionListener = new SpeechRecognitionListener();
        recognitionProgressView.setRecognitionListener(speechRecognitionListener);

        if (!mIslistening)
        {
            speechRecognizer.startListening(intent);
        }


    }
    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.RECORD_AUDIO)) {
            //  Toast.makeText(this, "Requires RECORD_AUDIO permission", Toast.LENGTH_SHORT).show();

        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[] { Manifest.permission.RECORD_AUDIO },
                    REQUEST_RECORD_AUDIO_PERMISSION_CODE);


        }
    }

    protected class SpeechRecognitionListener implements RecognitionListener {

        @Override
        public void onBeginningOfSpeech()
        {
            //Log.d(TAG, "onBeginingOfSpeech");
        }

        @Override
        public void onBufferReceived(byte[] buffer)
        {

        }

        @Override
        public void onEndOfSpeech()
        {
            //Log.d(TAG, "onEndOfSpeech");
        }

        @Override
        public void onError(int error)
        {
            speechRecognizer.startListening(intent);

            //Log.d(TAG, "error = " + error);
        }

        @Override
        public void onEvent(int eventType, Bundle params)
        {

        }

        @Override
        public void onPartialResults(Bundle partialResults)
        {

        }

        @Override
        public void onReadyForSpeech(Bundle params)
        {
            // Log.d(TAG, "onReadyForSpeech"); //$NON-NLS-1$
        }

        @Override
        public void onResults(Bundle results)
        {

            Log.e("results", String.valueOf(results));
            ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);


            for (String s : matches) {
                Log.e("soued", s);
            }
            startRecognition();



        }

        @Override
        public void onRmsChanged(float rmsdB)
        {
        }
    }

    public void JSON_DATA_WEB_CALL() {

        jsonArrayRequest = new JsonArrayRequest(GET_JSON_DATA_HTTP_URL ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JSON_PARSE_DATA_AFTER_WEBCALL(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);
        swipeRefreshLayout.setRefreshing(false);
    }




    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            final GetDataAdapterCheckBox_modify GetDataAdapter2 = new GetDataAdapterCheckBox_modify();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                GetDataAdapter2.setid(json.getString(JSON_ID));
                GetDataAdapter2.setproblem(json.getString(JSON_PROBLEM));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);

        }


        recyclerViewadapter1 = new RecyclerViewAdapterCheckBox_modify(GetDataAdapter1, getActivity());
        recyclerView.setAdapter(recyclerViewadapter1);



    }


    @Override
    public void onClick(View view) {
        if(view==floatingActionButton){
            dialog();
        }
    }


    private void dialog(){


        new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("คุณแน่ใจไหม?")
                .setContentText("ที่ต้องการแจ้งการแก้ไขปัญหานี้แล้ว!")
                .setCancelText("ไม่!")
                .setConfirmText("ใช่!")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        Log.e("3333","3333");
                        sDialog.cancel();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(final SweetAlertDialog sDialog) {
                        Log.e("rrrr", "rrrr");
                        sDialog.cancel();

                        stringBuilder = new StringBuilder();
                        stringBuilder2 = new StringBuilder();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder4 = new StringBuilder();

                        for (GetDataAdapterCheckBox_modify number : GetDataAdapter1) {
                            if (number.isSelected()) {

                                if (stringBuilder.length() > 0)
                                    stringBuilder.append(",");


                                stringBuilder.append(number.getproblem());


                                if (stringBuilder2.length() > 0)
                                    stringBuilder2.append(",");
                                stringBuilder2.append(number.getid());
                                kaka = stringBuilder;

                            }


                            if (number.isSelected()) {

                                if (stringBuilder3.length() > 0)
                                    stringBuilder3.append(",");


                                stringBuilder3.append(number.getproblem());


                                if (stringBuilder4.length() > 0)
                                    stringBuilder4.append(",");
                                stringBuilder4.append(number.getid());

                            }

                        }
                        DADA = stringBuilder2.toString();
                        DADA2 = stringBuilder.toString();
                        DADA3 = stringBuilder3.toString();

                        Log.e("a1", DADA);
                        Log.e("a2", kaka + "");
                        Log.e("a3", DADA2 + "");
                        Log.e("a4", Description + "");


                        try {



                            if (stringBuilder2.toString() == "") {
                                DADA = "NULL";
                                Log.e("ยังไม่เลือกปัญหา", "ยังไม่เลือกปัญหา");
                                final Dialog dialog = new Dialog(getActivity());
                                dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
                                dialog.setContentView(R.layout.customdialog_check_press_checkbox);
                                dialog.setCancelable(true);

                                Button button1 = (Button) dialog.findViewById(R.id.button1);
                                button1.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        Toast.makeText(getActivity()
                                                , "Close dialog", Toast.LENGTH_SHORT);
                                        dialog.cancel();

                                    }
                                });

                                dialog.show();



                            } else {

                                insent_report_problem();
                                //nontification_cedit_to_sale();
                                // dialog2.cancel();

                            }

                        }
                        catch (Exception ex){


                        }


                    }


                })
                .show();



    }

    public void insent_report_problem() {
        String contno= MyApplication.getInstance().getPrefManager().getPreferrence("conno_qr");//More
        String CreateBy=MyApplication.getInstance().getPrefManager().getPreferrence("EMPID");

        jsonArrayRequest = new JsonArrayRequest(GET_insent_report_problem+"?contno="+contno+"&problem="+DADA+"&type="+"General"+"&CreateBy="+CreateBy ,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        //nontification_cedit_to_sale();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }



    String GET_nontification_to_sale="http://app.thiensurat.co.th/assanee/api_sale_all_problem_from_cedit/firebase_nontification_sale_from_cedit/index.php";
    public void nontification_cedit_to_sale() {
        String contno= MyApplication.getInstance().getPrefManager().getPreferrence("conno_qr");//More
        String image_cedit=MyApplication.getInstance().getPrefManager().getPreferrence("picture");//More
        String name_cedit=MyApplication.getInstance().getPrefManager().getPreferrence("EmployeeName");//More
        jsonArrayRequest = new JsonArrayRequest(GET_nontification_to_sale+"?contno="+contno+"&problem="+DADA+"&name_cedit="+name_cedit+"&image_cedit="+image_cedit,


                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(jsonArrayRequest);

    }



}