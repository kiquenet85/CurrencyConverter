package com.app.ndiazgranados.catalog.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.ndiazgranados.catalog.R;
import com.app.ndiazgranados.catalog.model.web.Entry;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

/**
 * @author n.diazgranados
 */
public class TopAppsAdapter extends RecyclerView.Adapter<TopAppsAdapter.ViewHolder> {

    public interface OnTopAppClickListener {
        void onTopAppClicked(View view);
    }

    private List<Entry> dataSet;
    private OnTopAppClickListener onTopAppClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View container;
        public ImageView imageApp;
        public TextView labelApp;

        public ViewHolder(View viewRow) {
            super(viewRow);
            container = viewRow;
            imageApp = (ImageView) viewRow.findViewById(R.id.fragment_top_apps_image);
            labelApp = (TextView) viewRow.findViewById(R.id.fragment_top_apps_label);
        }
    }

    public TopAppsAdapter(List<Entry> myDataset, OnTopAppClickListener onCategoryClickListener) {
        dataSet = myDataset;
        this.onTopAppClickListener = onCategoryClickListener;
    }

    public List<Entry> getDataSet() {
        return dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TopAppsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
            int viewType) {
        // create a new view
        View viewRow = LayoutInflater.from(parent.getContext())
                                     .inflate(R.layout.fragment_top_apps_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(viewRow);
        viewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.zoom_fade_out);
                animation.setAnimationListener(new Animation
                        .AnimationListener
                        () {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        onTopAppClickListener.onTopAppClicked(view);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view.startAnimation(animation);
            }
        });
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Entry entry = (Entry) dataSet.get(position);
        holder.labelApp.setText(entry.getImName().getLabel());

        Context context = holder.imageApp.getContext();
        String imageURL = entry.getImImage().get(0).getLabel().replaceAll(context.getString(R.string.size_regex_top_app),
                context.getString(R.string.frag_top_apps_size_web_image));
        Picasso.with(context).load(imageURL).into(holder.imageApp);
        setAnimation(holder.container, position);
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        Random random = new Random();
        setAnimation(holder.container, random.nextInt(((9 - 7) + 1) + 7));
    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position) {
        Animation animation = (position % 2 == 0) ?
                              AnimationUtils.loadAnimation(viewToAnimate.getContext(), android.R.anim.slide_in_left) :
                              AnimationUtils.loadAnimation(viewToAnimate.getContext(), android.R.anim.slide_out_right);
        viewToAnimate.startAnimation(animation);
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.container.clearAnimation();
    }

    @Override
    public int getItemCount() {
        return (dataSet != null) ? dataSet.size() : 0;
    }

    public List<Entry> getDataset(){
        return dataSet;
    }
}