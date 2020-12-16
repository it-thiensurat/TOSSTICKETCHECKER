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
import android.widget.TextView;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_sale_edit_problem;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.SectionDataModel2;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDataAdapter6 extends RecyclerView.Adapter<RecyclerViewDataAdapter6.ItemRowHolder>  {

    private ArrayList<SectionDataModel2> dataList;List<GetData_cedit_sale_edit_problem> getDataAdapter;
    private Context mContext;

    public RecyclerViewDataAdapter6(Context context, ArrayList<SectionDataModel2> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mp3_online_list_item, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        final String sectionName = dataList.get(i).getHeaderTitle();

        ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();

        itemRowHolder.itemTitle.setText(sectionName);

        SectionListDataAdapter6 itemListDataAdapter = new SectionListDataAdapter6(mContext, singleSectionItems);

        itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);


         itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);


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

/*        itemRowHolder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();



            }
        });*/





/*        itemRowHolder.deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();



            }
        });*/



/*        itemRowHolder.moreAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();



            }
        });*/

       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }




    private RecyclerViewDataAdapter6.itemclick_deleteAll ic_deleteAll;
    public void setitemclick_deleteAll(RecyclerViewDataAdapter6.itemclick_deleteAll deleteAll){
        this.ic_deleteAll=deleteAll;
    }



    public interface itemclick_deleteAll{


        void click_deleteAll(View v, int position);
    }




    public class ItemRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        protected TextView itemTitle;

        protected RecyclerView recycler_view_list;

        protected Button btnMore;


        protected TextView deleteAll;
        protected TextView moreAll;



        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);

            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            this.btnMore= (Button) view.findViewById(R.id.btnMore);

            this.deleteAll = (TextView) view.findViewById(R.id.deleteAll);
            this.moreAll = (TextView) view.findViewById(R.id.moreAll);
            deleteAll.setVisibility(View.GONE);

            btnMore.setOnClickListener(this);
            moreAll.setOnClickListener(this);



        }

        @Override
        public void onClick(View v) {
            if(v==btnMore){
                try {
                    if(ic_deleteAll!=null){
                        ic_deleteAll.click_deleteAll(btnMore,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }
            else        if(v==moreAll){
                try {
                    if(ic_deleteAll!=null){
                        ic_deleteAll.click_deleteAll(moreAll,getPosition());
                    }
                }


                catch (Exception e) {

                    e.printStackTrace();
                }
            }



        }
    }


}