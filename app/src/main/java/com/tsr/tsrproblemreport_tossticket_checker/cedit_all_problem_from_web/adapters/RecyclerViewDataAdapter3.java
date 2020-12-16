package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.ImageBefore;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SectionDataModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDataAdapter3 extends RecyclerView.Adapter<RecyclerViewDataAdapter3.ItemRowHolder> {

    private ArrayList<SectionDataModel> dataList;
    ArrayList singleSectionItems;
    SectionListDataAdapter itemListDataAdapter;
    private List<ImageBefore> imageBeforeList;
    private Context mContext;

    public RecyclerViewDataAdapter3(Context context, ArrayList<SectionDataModel> dataList,List<ImageBefore> imageBeforeList2) {
        this.dataList = dataList;
        this.mContext = context;
        this.imageBeforeList=imageBeforeList2;

//        Log.e("imageBeforeList", imageBeforeList.size() + "");
      itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems,imageBeforeList);
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mp3_online_list_item, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {



        itemRowHolder.itemTitle.setBackgroundResource(R.drawable.roun_rect_orange10);
        itemRowHolder.moreAll.setBackgroundResource(R.drawable.roun_rect_orange10);
        if (i == 0) {
            itemRowHolder.itemTitle.setText("ล่าสุด");
        }

        try {
            if(imageBeforeList.size()==0){
                itemRowHolder.view.setVisibility(View.GONE);
            }
            else {
                itemRowHolder.view.setVisibility(View.VISIBLE);
            }
        }
        catch (Exception ex){

        }


       /*  itemRowHolder.recycler_view_list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        //Allow ScrollView to intercept touch events once again.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                // Handle RecyclerView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });*/

        itemRowHolder.btnMore.setVisibility(View.GONE);
        itemRowHolder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();



            }
        });




        itemRowHolder.deleteAll.setVisibility(View.GONE);
        itemRowHolder.deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();



            }
        });



        itemRowHolder.moreAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();



            }
        });

       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return 1;
    }




    private RecyclerViewDataAdapter3.itemclick_deleteAll ic_deleteAll;
    public void setitemclick_deleteAll(RecyclerViewDataAdapter3.itemclick_deleteAll deleteAll){
        this.ic_deleteAll=deleteAll;
    }
    public interface itemclick_deleteAll{


        void click_deleteAll(View v, int position);
    }






    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;

        protected RecyclerView recycler_view_list;

        protected Button btnMore;


        protected TextView deleteAll;
        protected TextView moreAll;
        protected LinearLayout view;


        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);

            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            this.btnMore= (Button) view.findViewById(R.id.btnMore);

            this.deleteAll = (TextView) view.findViewById(R.id.deleteAll);
            this.moreAll = (TextView) view.findViewById(R.id.moreAll);
            this.view= (LinearLayout) view.findViewById(R.id.view);

            recycler_view_list.setHasFixedSize(true);
            recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            recycler_view_list.setAdapter(itemListDataAdapter);
            recycler_view_list.setNestedScrollingEnabled(false);
            deleteAll.setVisibility(View.GONE);
        }

    }

}