package hu.bme.aut.amorg.examples.launcher.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import hu.bme.aut.amorg.examples.launcher.R;
import hu.bme.aut.amorg.examples.launcher.model.ApplicationInfo;

public class ApplicationsAdapter extends RecyclerView.Adapter<ApplicationsAdapter.ViewHolder> {

    private Context context;
    private final List<ApplicationInfo> applications;
    private LayoutInflater mInflater;

    public ApplicationsAdapter(Context context, List<ApplicationInfo> applications) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.applications = applications;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.li_application, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ApplicationInfo app = applications.get(position);
        holder.nameTV.setText(app.getTitle());
        holder.iconIV.setImageDrawable(app.getIcon());

        holder.applicationsLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(app.getIntent());
            }
        });
        
    }

    @Override
    public int getItemCount() {
        return applications.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout applicationsLL;
        public TextView nameTV;
        public ImageView iconIV;

        public ViewHolder(View view) {
            super(view);
            applicationsLL = (LinearLayout) view.findViewById(R.id.applicationLL);
            nameTV = (TextView) view.findViewById(R.id.nameTV);
            iconIV = (ImageView) view.findViewById(R.id.iconIV);
           
        }
    }




}