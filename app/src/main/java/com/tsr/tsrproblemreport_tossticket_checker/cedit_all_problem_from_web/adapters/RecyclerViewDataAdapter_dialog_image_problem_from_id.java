package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.adapters;



/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;


        import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
        import com.bumptech.glide.Glide;
        import com.tsr.tsrproblemreport_tossticket_checker.R;
        import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.models.GetData_cedit_dialog_image_problem_from_id;

        import java.util.List;

public class RecyclerViewDataAdapter_dialog_image_problem_from_id extends RecyclerView.Adapter<RecyclerViewDataAdapter_dialog_image_problem_from_id.ItemRowHolder> {

    private List<GetData_cedit_dialog_image_problem_from_id> dataList;
    private Context mContext;

    public RecyclerViewDataAdapter_dialog_image_problem_from_id(Context context, List<GetData_cedit_dialog_image_problem_from_id> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mp3_online_list_single_card_dialog_custom_image_problem, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        final GetData_cedit_dialog_image_problem_from_id getData_cedit_dialog_image_problem_from_id = dataList.get(i);
        itemRowHolder.tvTitle.setText("รูปที่ "+(i+1));
        try {
            Glide.with(mContext).load(getData_cedit_dialog_image_problem_from_id.getImage_id_all())




                    .into(itemRowHolder.itemImage);

            itemRowHolder.itemImage.setOnTouchListener(new ImageMatrixTouchHandler(mContext));
        }
        catch (Exception e) {

        }
//
      //

    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }




    private RecyclerViewDataAdapter.itemclick_deleteAll ic_deleteAll;
    public void setitemclick_deleteAll(RecyclerViewDataAdapter.itemclick_deleteAll deleteAll){
        this.ic_deleteAll=deleteAll;
    }
    public interface itemclick_deleteAll{


        void click_deleteAll(View v, int position);
    }






    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected ImageView itemImage,image_remove,image_cancal;
        protected TextView tvTitle;


        public ItemRowHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
            this.image_remove = (ImageView) view.findViewById(R.id.image_remove);
            this.image_cancal = (ImageView) view.findViewById(R.id.image_cancal);
            image_remove.setVisibility(View.GONE);
            image_cancal.setVisibility(View.GONE);
            image_cancal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }

}
