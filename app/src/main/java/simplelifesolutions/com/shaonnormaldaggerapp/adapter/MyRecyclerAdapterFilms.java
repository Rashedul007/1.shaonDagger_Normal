package simplelifesolutions.com.shaonnormaldaggerapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import simplelifesolutions.com.shaonnormaldaggerapp.R;

public class MyRecyclerAdapterFilms {/*extends RecyclerView.Adapter<MyRecyclerAdapterFilms.StarWarsViewHolder> {

    private List<StarWars.People> resultList = new ArrayList<>();


    public MyRecyclerAdapterFilms() {
    }

    @Override
    public StarWarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_row, parent, false);
        return new StarWarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StarWarsViewHolder holder, int position) {
        StarWars.People result = resultList.get(position);

        Log.d("testLog--", "Name is: " +result.name.toString()
                + "--"
                + "Birth is: " + result.birthYear.toString() );

        holder.txtVwName.setText("Name: " + result.name.toString());
        holder.txtVwBirth.setText("DOB: " + result.birthYear.toString());
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setItems(List<StarWars.People> results) {
        resultList = results;
        notifyDataSetChanged();
    }

    public class StarWarsViewHolder extends RecyclerView.ViewHolder {
        public TextView txtVwName;
        public TextView txtVwBirth;

        public StarWarsViewHolder(View itemView) {
            super(itemView);
            txtVwName = itemView.findViewById(R.id.txtName);
            txtVwBirth = itemView.findViewById(R.id.txtBirthYear);
        }
    }*/
}