package chapter.android.aweme.ss.com.homework;


import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.NumberViewHolder> {
    private static final String TAG = "MyAdapter";
    private int mNumberItems;
    private final ListItemClickListener mONClickListener;

    private List<Message> mdata;

    public MyAdapter(List<Message> data, ListItemClickListener Listener){
        mdata = data;
        mONClickListener=Listener;
    }


    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context=viewGroup.getContext();
        int layoutIdForListItem=R.layout.im_list_item;
        LayoutInflater inflater=LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately=false;
        View view=inflater.inflate(layoutIdForListItem,viewGroup,shouldAttachToParentImmediately);
        NumberViewHolder viewHolder=new NumberViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.NumberViewHolder numViewHolder, int i) {
        Log.d(TAG,"onBindViewHolder: #"+i);
        numViewHolder.bind(i);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }


    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //private final TextView viewHolderIndex;
        //private final TextView listItemNumberView;

        private TextView my_title;
        private TextView my_words;
        private TextView my_time;
        private CircleImageView my_image;
        private ImageView my_official;

        public NumberViewHolder(@NonNull View itemView){
            super(itemView);
//           listItemNumberView=(TextView)itemView.findViewById(R.id.tv_item_number);
//           viewHolderIndex=(TextView)itemView.findViewById(R.id.tv_view_holder_instance);
//            itemView.setOnClickListener(this);
            my_title=(TextView)itemView.findViewById(R.id.tv_title);
            my_words=(TextView)itemView.findViewById(R.id.tv_description);
            my_time=(TextView)itemView.findViewById(R.id.tv_time);
            my_image=(CircleImageView)itemView.findViewById(R.id.iv_avatar);
            my_official=(ImageView)itemView.findViewById(R.id.robot_notice);
            itemView.setOnClickListener(this);
        }

        public void bind(int position){
            //listItemNumberView.setText(String.valueOf(position));

            my_title.setText(mdata.get(position).getTitle());
            my_words.setText(mdata.get(position).getDescription());
            my_time.setText(mdata.get(position).getTime());

            //图标有官方认证，要特殊判断
            my_official.setImageResource(R.drawable.im_icon_notice_official);
            if(mdata.get(position).isOfficial()){
                my_official.setVisibility(View.VISIBLE);
            }
            else{
                my_official.setVisibility(View.INVISIBLE);
            }

            if(mdata.get(position).getIcon().equals("TYPE_ROBOT")){
                my_image.setImageResource(R.drawable.session_robot);
            }
            else if(mdata.get(position).getIcon().equals("TYPE_SYSTEM")){
                my_image.setImageResource(R.drawable.session_system_notice);
            }
            else if(mdata.get(position).getIcon().equals("TYPE_GAME")){
                my_image.setImageResource(R.drawable.icon_micro_game_comment);
            }
            else if(mdata.get(position).getIcon().equals("TYPE_STRANGER")){
                my_image.setImageResource(R.drawable.session_stranger);
            }
            else if(mdata.get(position).getIcon().equals("TYPE_USER")){
                my_image.setImageResource(R.drawable.icon_girl);
            }
        }
        @Override
        public void onClick(View v){
            int clickedPosition =getAdapterPosition();
            if(mONClickListener!=null){
                mONClickListener.onListItemClick(clickedPosition);
            }
        }
    }
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    //    @NonNull
//    @Override
//    public NumberViewHolder onCreteViewHolder(@NonNull ViewGroup viewGroup,int viewType){
//        Context context=viewGroup.getContext();
//        int layoutIdForListItem=R.layout.number_list_item;
//        LayoutInflater inflater=LayoutInflater.from(context);
//        boolean shouldAttachToParentImmediately=false;
//
//        View view=inflater.inflate(layoutIdForListItem,viewGroup,shouldAttachToParentImmediately);
//        NumberViewHolder viewHolder=new NumberViewHolder(view);
//
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder,int position){
//        Log.d(TAG,"onBindViewHolder:#"+position);
//        numberViewHolder.bind(position);
//    }
//
//
//
//    @Override
//    public int getItemCount(){
//        return mNumberItems;
//    }

//    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        private final TextView viewHolderIndex;
//        private final TextView listItemNumberView;
//
//        public NumberViewHolder(@NonNull View itemView){
//            super(itemView);
//            listItemNumberView=(TextView)itemView.findViewById(R.id.tv_item_number);
//            viewHolderIndex=(TextView)itemView.findViewById(R.id.tv_view_holder_instance);
//            itemView.setOnClickListener(this);
//        }
//        public void bind(int position){
//
//            listItemNumberView.setText(String.valueOf(position));
//        }
//
//        @Override
//        public void onClick(View v){
//            int clickedPosition=getAdapterPosition();
//            if(mONClickListener!=null){
//                mONClickListener.onListItemClick(clickedPosition);
//            }
//        }
//    }
//    public interface ListItemClickListener{
//        void onListItemClick(int clickedItemIndex);
//    }


}
