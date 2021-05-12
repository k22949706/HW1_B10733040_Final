package com.example.hw1_b10733040;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<ScannedData> arrayList = new ArrayList<>();

    private Context context;
    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    /**清除搜尋到的裝置列表*/
    public void clearDevice(){
        arrayList.clear();
        notifyDataSetChanged();
    }

    /**若有不重複的裝置出現，則加入列表中*/
    public void addDevice(List<ScannedData> arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvAddress,tvInfo,tvRssi;
        Button tvButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textView_DeviceName);
            tvAddress = itemView.findViewById(R.id.textView_Address);
            tvInfo = itemView.findViewById(R.id.textView_ScanRecord);
            tvRssi = itemView.findViewById(R.id.textView_Rssi);
            tvButton = itemView.findViewById(R.id.button_Detail);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scanned_item,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(arrayList.get(position).getDeviceName());
        holder.tvAddress.setText("裝置位址："+arrayList.get(position).getAddress());
        holder.tvInfo.setText("裝置資訊：\n"+arrayList.get(position).getDeviceByteInfo());
        holder.tvRssi.setText("訊號強度："+arrayList.get(position).getRssi());
        //抓Navigation的action並設置OnClickListener
        AFragmentDirections.ActionAFragmentToBFragment action = AFragmentDirections.actionAFragmentToBFragment();
        action.setMessage(arrayList.get(position).getDeviceName());
        action.setMessage2("訊號強度："+arrayList.get(position).getRssi());
        action.setMessage3("裝置位址："+ arrayList.get(position).getAddress());
        action.setMessage4("裝置資訊：\n"+arrayList.get(position).getDeviceByteInfo());
        holder.tvButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(action)
        );
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
