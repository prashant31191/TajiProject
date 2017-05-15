package com.jxlc.tajiproject.ui.layout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.jxlc.tajiproject.R;
import com.jxlc.tajiproject.ui.widgets.InfoPanelItemTitle;
import com.randal.aviana.ui.ExpandableLayout;

/**
 * Created by Randal on 2017-05-13.
 */

public class ConstructionSiteInfoPanel extends LinearLayout implements View.OnClickListener {
    private Context mContext;
    private InfoPanelItemTitle mRunningStatusTitle;
    private ExpandableLayout expandableLayout0;
    private ExpandableLayout expandableLayout1;

    public ConstructionSiteInfoPanel(@NonNull Context context) {
        this(context, null);
    }

    public ConstructionSiteInfoPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_siteinfopanel, this, true);
        mContext = context;

        expandableLayout0 = (ExpandableLayout) findViewById(R.id.expandable_layout_0);
        expandableLayout1 = (ExpandableLayout) findViewById(R.id.expandable_layout_1);

        expandableLayout0.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("ExpandableLayout0", "State: " + state);
            }
        });

        expandableLayout1.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("ExpandableLayout1", "State: " + state);
            }
        });

        mRunningStatusTitle = (InfoPanelItemTitle)findViewById(R.id.running_status_title);
        mRunningStatusTitle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (expandableLayout0.isExpanded()) {
            mRunningStatusTitle.setDirection(InfoPanelItemTitle.ARROW_UP);
            expandableLayout0.collapse();
        } else if (expandableLayout1.isExpanded()) {
            mRunningStatusTitle.setDirection(InfoPanelItemTitle.ARROW_RIGHT);
            expandableLayout1.collapse();
        } else {
            mRunningStatusTitle.setDirection(InfoPanelItemTitle.ARROW_LEFT);
            expandableLayout0.expand();
            expandableLayout1.expand();
        }
    }
}
