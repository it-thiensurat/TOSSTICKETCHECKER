package com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tsr.tsrproblemreport_tossticket_checker.R;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.adapter.HistoryAdapter;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.data.preference.AppPreference;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.data.preference.PrefKey;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.utility.AppUtils;
import com.tsr.tsrproblemreport_tossticket_checker.cedit_all_problem_from_web.qrcode.utility.DialogUtils;

import java.util.ArrayList;
import java.util.Collections;

public class HistoryFragment extends Fragment {

    private Activity mActivity;
    private Context mContext;

    private TextView noResultView;
    private RecyclerView mRecyclerView;
    private ArrayList<String> arrayList;
    private HistoryAdapter adapter;
    private FloatingActionButton deleteAll;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);

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
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        noResultView = (TextView) rootView.findViewById(R.id.noResultView);
        deleteAll = (FloatingActionButton) rootView.findViewById(R.id.deleteAll);
    }

    private void initFunctionality() {
        arrayList = new ArrayList<>();
        adapter = new HistoryAdapter(mContext, arrayList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(adapter);

        arrayList.addAll(AppPreference.getInstance(mContext).getStringArray(PrefKey.RESULT_LIST));
        Collections.reverse(arrayList);
        refreshList();
    }

    private void initListener() {
        adapter.setClickListener(new HistoryAdapter.ClickListener() {
            @Override
            public void onCopyClicked(int position) {
                AppUtils.copyToClipboard(mContext, arrayList.get(position));
            }

            @Override
            public void onItemClicked(int position) {
                AppUtils.executeAction(mActivity, arrayList.get(position), AppUtils.getResourceType(arrayList.get(position)));
            }

            @Override
            public void onItemLongClicked(final int position) {
                DialogUtils.showDialogPrompt(mActivity, null, getString(R.string.delete_message_item),
                        getString(R.string.yes), getString(R.string.no), true, new DialogUtils.DialogActionListener() {
                            @Override
                            public void onPositiveClick() {
                                delete(position);
                            }
                        });
            }

        });

        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showDialogPrompt(mActivity, null, getString(R.string.delete_message_all),
                        getString(R.string.yes), getString(R.string.no), true, new DialogUtils.DialogActionListener() {
                            @Override
                            public void onPositiveClick() {
                                deleteAll();
                            }
                        });
            }
        });
    }

    private void delete(int position) {
        AppPreference.getInstance(mContext).setStringArray(PrefKey.RESULT_LIST, null);
        arrayList.remove(position);
        AppPreference.getInstance(mContext).setStringArray(PrefKey.RESULT_LIST, arrayList);
        refreshList();
    }

    private void deleteAll() {
        AppPreference.getInstance(mContext).setStringArray(PrefKey.RESULT_LIST, null);
        arrayList.clear();
        refreshList();
    }

    private void refreshList() {
        if(arrayList.isEmpty()) {
            noResultView.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
            deleteAll.hide();
        } else {
            noResultView.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            deleteAll.show();
        }
        adapter.notifyDataSetChanged();
    }





}
