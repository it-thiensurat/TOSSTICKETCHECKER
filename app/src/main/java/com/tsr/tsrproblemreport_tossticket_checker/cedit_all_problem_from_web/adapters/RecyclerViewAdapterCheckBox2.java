package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetDataAdapterCheckBox;

import java.util.Date;
import java.util.List;

import static com.tsr.tsrproblemreport_tossticket_checker.R.id;

/**
 * Created by JUNED on 6/16/2016.
 */
public class RecyclerViewAdapterCheckBox2 extends RecyclerView.Adapter<RecyclerViewAdapterCheckBox2.ViewHolder> {

    Context context;

    List<GetDataAdapterCheckBox> getDataAdapter;

    ImageLoader imageLoader1;
    String s1,s2,s3,s4,s5,s6;
    int converted1,converted2,converted3,converted4,converted5,converted6;
    String ggg;
    String CP;
    private Date oneWayTripDate;
    public RecyclerViewAdapterCheckBox2(List<GetDataAdapterCheckBox> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_checkbox_cardview_cedit2, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder Viewholder, int position) {

        GetDataAdapterCheckBox getDataAdapter1 =  getDataAdapter.get(position);
        //  FeddProperties fp = dataSet.get(i);

        /*
        imageLoader1 = ServerImageParseAdapter.getInstance(context).getImageLoader();

        imageLoader1.get(getDataAdapter1.getpicture(),
                ImageLoader.getImageListener(
                        Viewholder.networkImageView,//Server Image
                        mipmap.ic_launcher,//Before loading server image the default showing image.
                        android.R.drawable.ic_dialog_alert //Error image if requested image dose not found on server.
                )
        );
*/

        Viewholder.checkBox.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected
        Viewholder.checkBox.setChecked(getDataAdapter.get(position).isSelected());

        Viewholder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getDataAdapter.get(Viewholder.getAdapterPosition()).setSelected(isChecked);
            }
        });

        Viewholder.lbl_problem.setText(getDataAdapter1.getproblem2());
        // Viewholder.checkBox.setText(getDataAdapter1.isSelected());

       // Viewholder.checkBox.setChecked(true);
        String ID=getDataAdapter1.getid2()+"";

        Log.e("ID2",ID);
        // if(){

        // }
















        Viewholder.feed = getDataAdapter1;

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }












    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView lbl_problem;
        public CheckBox checkBox;

        //  public ImageView networkImageView ;



        public GetDataAdapterCheckBox feed;
        public ViewHolder(View itemView) {

            super(itemView);






            lbl_problem = (TextView) itemView.findViewById(id.lbl_problem) ;
            checkBox= (CheckBox) itemView.findViewById(id.checkBox) ;




            //  networkImageView = (ImageView) itemView.findViewById(id.VollyNetworkImageView1) ;





            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //String ckeckposition= getDataAdapter1.getposition();

                    //      Intent mIntent = new Intent(v.getContext(), UI_SHOW_PROBLEM.class);
                    //       Bundle bun=new Bundle();
                    //  bun.putString("namethai", feed.getnamethai());

                    //title.setText()

                    //   mIntent.putExtras(bun);
///
                    //  v.getContext().startActivity(mIntent);












                }
            });





        }
    }
}
