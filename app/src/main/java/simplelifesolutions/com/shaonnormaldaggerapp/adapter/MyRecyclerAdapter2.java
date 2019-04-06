package simplelifesolutions.com.shaonnormaldaggerapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import simplelifesolutions.com.shaonnormaldaggerapp.R;
import simplelifesolutions.com.shaonnormaldaggerapp.models.Result;

public class MyRecyclerAdapter2 extends RecyclerView.Adapter<MyRecyclerAdapter2.StarWarsViewHolder> {

    final String LOG_TAG = "testLogTag";
    private List<Result> resultList ;


    public MyRecyclerAdapter2() {
        resultList = new ArrayList<>();
    }

    @Override
    public StarWarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_row_second, parent, false);
        return new StarWarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StarWarsViewHolder holder, int position) {
        Result result = resultList.get(position);

        Log.d("LOG_TAG", "Inside Adapter--" + "Name is: " + result.getName().getFirst()
                + "--"
                + "Age is: " + result.getDob().getAge() );

        holder.txtVwName.setText("Name: " + result.getName().getFirst().toString() );
        holder.txtVwBirth.setText("DOB: " + result.getDob().getAge() );
        holder.txtVwGender.setText("DOB: " + result.getGender().toString() );
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setItems(List<Result> results) {
        resultList = results;
        notifyDataSetChanged();
    }

    public class StarWarsViewHolder extends RecyclerView.ViewHolder {
        public TextView txtVwName;
        public TextView txtVwBirth;
        public TextView txtVwGender;
        public LinearLayout myLayout;

        public StarWarsViewHolder(View itemView) {
            super(itemView);

            txtVwName = itemView.findViewById(R.id.txtName2);
            txtVwBirth = itemView.findViewById(R.id.txtBirthYear2);
            txtVwGender = itemView.findViewById(R.id.txtGender2);
            myLayout = itemView.findViewById(R.id.MyListRowLayout2);

        }
    }


}