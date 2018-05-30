package cl.magnet.mobileappsexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cl.magnet.mobileappsexample.FormsListFragment.OnListFragmentInteractionListener;
import cl.magnet.mobileappsexample.db.Form;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Form} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class FormListAdapter extends RecyclerView.Adapter<FormListAdapter.FormViewHolder> {

    private List<Form> mForms = null;
    private final OnListFragmentInteractionListener mListener;

    public FormListAdapter( OnListFragmentInteractionListener listener) {
        mListener = listener;
    }

    public void setForms(List<Form> mForms) {
        this.mForms = mForms;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FormViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new FormViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FormViewHolder holder, int position) {

        if(mForms != null) {
            holder.mForm = mForms.get(position);
            String id = mForms.get(position).getUid() + "";
            holder.mIdView.setText(id);
            holder.mTitleView.setText(mForms.get(position).getName());
            holder.mDateView.setText(mForms.get(position).getDate());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        mListener.onListFragmentInteraction(holder.mForm);
                    }
                }
            });
        }else{
            // Covers the case of data not being ready yet.
            holder.mTitleView.setText("No Forms");
        }
    }

    @Override
    public int getItemCount() {
        if (mForms != null)
            return mForms.size();
        else return 0;
    }

    public class FormViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mTitleView;
        public final TextView mDateView;
        public Form mForm;

        public FormViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
            mTitleView = view.findViewById(R.id.title);
            mDateView = view.findViewById(R.id.date);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }
    }
}
