package com.tsr.tsrproblemreport_tossticket_checker.mvp.base.adapter.loadmore;

import android.view.ViewGroup;

import java.util.List;

import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.adapter.BaseItem;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.adapter.BaseItemType;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.adapter.BaseMvpListAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.adapter.BaseViewHolder;
import com.tsr.tsrproblemreport_tossticket_checker.mvp.base.adapter.progress.ProgressHolder;


/**
 * Created by thekhaeng on 4/24/2017 AD.
 */

public abstract class LoadmoreAdapter<VH extends BaseViewHolder, P extends LoadmoreAdapterInterface.Presenter>
        extends BaseMvpListAdapter<VH, P>
        implements LoadmoreAdapterInterface.Adapter{

    private OnLoadMoreListener loadMoreListener;

    public void setOnLoadMoreListener( OnLoadMoreListener listener ){
        this.loadMoreListener = listener;
    }

    public void setItems(List<BaseItem> items, boolean isNextItemAvailable ){
        getPresenter().setItems( items, isNextItemAvailable );
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public VH onCreateViewHolder( ViewGroup parent, int viewType ){
        if( viewType == BaseItemType.TYPE_PROGRESS ){
            return (VH) new ProgressHolder( parent );
        }
        return null;
    }

    @Override
    public void onBindViewHolder( VH holder, int position ){
        if( getItemViewType( position ) == BaseItemType.TYPE_PROGRESS ){
            if( loadMoreListener != null ){
                loadMoreListener.onLoadMore();
            }
        }
    }
}
