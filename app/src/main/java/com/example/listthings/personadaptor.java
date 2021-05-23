package com.example.listthings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class personadaptor extends RecyclerView.Adapter<personadaptor.ViewHolder> {
        ArrayList<listinfo> lt;
        public interface listclick{
            void onlistclick(int index);
        }
        listclick c;
        private Context context;

        public personadaptor(Context context, ArrayList<listinfo> r)
        {
            c=(listclick) context;
            lt=r;

        }

        public class ViewHolder  extends RecyclerView.ViewHolder implements View.OnLongClickListener
        {
            TextView tvname,tvdate,tvtime,tvs;
            ImageView ivp,imd;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvname=itemView.findViewById(R.id.tvname);
                tvdate=itemView.findViewById(R.id.tvdate);
                tvtime=itemView.findViewById(R.id.tvtime);
                ivp=itemView.findViewById(R.id.ivp);
                imd=itemView.findViewById(R.id.imd);
                tvs=itemView.findViewById(R.id.tvs);

                imd.setVisibility(View.INVISIBLE);
                tvdate.setVisibility(View.INVISIBLE);
                tvtime.setVisibility(View.INVISIBLE);
                itemView.setOnLongClickListener(this);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        c.onlistclick(lt.indexOf((listinfo) itemView.getTag()));
                    }
                });
            }

            @Override
            public boolean onLongClick(View v) {
                imd.setVisibility(View.VISIBLE);
                imd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position=getAdapterPosition();
                        lt.remove(position);
                        notifyItemRemoved(position);
                    }
                });


                return true;
            }
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.tvname.setText(lt.get(position).getName());
            holder.tvdate.setText(lt.get(position).getDate());
            holder.tvtime.setText(lt.get(position).getTime());
            holder.tvs.setText(lt.get(position).getS());

            holder.itemView.setTag(lt.get(position));
            if (lt.get(position).getP().equals("high")) {
                holder.ivp.setImageResource(R.drawable.red);
            } else if (lt.get(position).getP().equals("medium")) {
                holder.ivp.setImageResource(R.drawable.green);
            } else if (lt.get(position).getP().equals("low")) {
                holder.ivp.setImageResource(R.drawable.yellow);

            }
        }

        @Override
        public int getItemCount() {
            return lt.size();
        }
    }


