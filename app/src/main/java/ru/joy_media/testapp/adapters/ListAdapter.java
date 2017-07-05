package ru.joy_media.testapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.joy_media.testapp.MainActivity;
import ru.joy_media.testapp.R;

/**
 * Created by root on 05.07.2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private LayoutInflater inflater;
    public Context mContext;
    private List<MyList> mList;
    private ListViewHolder.CustomClickListener mCustomClickListener;

    public ListAdapter(List<MyList> list, ListViewHolder.CustomClickListener customClickListener) {
        mList = list;
        mCustomClickListener = customClickListener;
    }

    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ListViewHolder(convertView, mCustomClickListener);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ListViewHolder holder, int position) {
        final MyList myList = mList.get(position);
        holder.mTextView.setText(String.valueOf(myList.getMonth()));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected TextView mTextView;

        private CustomClickListener mListener;

        public ListViewHolder(View itemView, CustomClickListener customClickListener) {
            super(itemView);
            this.mListener = customClickListener;

            mTextView = (TextView) itemView.findViewById(R.id.textViewList);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mListener != null){
                mListener.onUserItemClickListener(getAdapterPosition());
            }
        }

        public interface CustomClickListener {

            void onUserItemClickListener(int position);
        }
    }
}
