package android.BB.ui.nearby;

import android.BB.bean.nearby.BBInfo;
import android.BB.finals.MyConstants;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.BB.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEWTYPE_ITEM = 0;
    public static final int VIEWTYPE_FOOT = 1;
    public static final int VIEWTYPE_DESC_SECOND=2;
    private List<BBInfo> mList;
    private BBInfo bbInfo;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;

    public RecyclerAdapter(Context context) {
        this.mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
        mList = new ArrayList<>();
        File file1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + MyConstants.IMAGE_PATH);
        File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + MyConstants.IMAGE_PATH + "/example.png");
        FileOutputStream fout = null;
        if (!file1.exists()) {
            try {
                file1.mkdir();
                file2.createNewFile();
                fout = new FileOutputStream(file2);
                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fout);
                fout.flush();
                fout.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                    fout = new FileOutputStream(file2);
                    Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fout);
                    fout.flush();
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        bbInfo = new BBInfo(1,Environment.getExternalStorageDirectory().getAbsolutePath() + MyConstants.IMAGE_PATH + "/example.png", "��æȥ��������", "300m", "����ǰ���ſ�", "15:56");
        for (int i = 0; i < 10; i++) {
            mList.add(bbInfo);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        switch(viewType){
            case VIEWTYPE_ITEM:
                View view1 = layoutInflater.inflate(R.layout.item_nearby_bb_list, viewGroup, false);
                return new ItemViewHolder(view1);
            case VIEWTYPE_FOOT:
                View view2 = layoutInflater.inflate(R.layout.recycler_foot, viewGroup, false);
                return new FootViewHolder(view2);
            case VIEWTYPE_DESC_SECOND:
                View view3 = layoutInflater.inflate(R.layout.item_nearby_bb_list, viewGroup, false);
                int margin_dp=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,7,mContext.getResources().getDisplayMetrics());
                RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(-2,-2);
                layoutParams.setMargins(margin_dp, margin_dp, margin_dp, 0);
                view3.setLayoutParams(layoutParams);
                return new ItemViewHolder(view3);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int pos) {
        if (viewHolder instanceof ItemViewHolder) {
            ((ItemViewHolder) viewHolder).bind(pos);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int viewType=0;
        if(position+1==getItemCount())
            viewType=VIEWTYPE_FOOT;
        else if(position+2==getItemCount())
            viewType=VIEWTYPE_DESC_SECOND;
        else
            viewType=VIEWTYPE_ITEM;
        return viewType;
//        return position + 1 == getItemCount() ? VIEWTYPE_FOOT : VIEWTYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    /*�������ظ���*/
    public void loadMore() {
        for(int i=0;i<10;i++){
            mList.add(bbInfo);
        }
        notifyItemInserted(getItemCount());
    }

    /*����ˢ��*/
    public void refresh() {

    }
    interface ItemClickListener{
        public void click(int info_id,int pos);
    }
    public void setClickListener(ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }
    class ItemViewHolder extends ViewHolder {
        private int info_id;
        private ImageView head;
        private TextView title;
        private TextView distance;
        private TextView time;
        private TextView position;
        private Button btn;
        public ItemViewHolder(View itemView) {
            super(itemView);
            head = (ImageView) itemView.findViewById(R.id.img_nearby_bb_item_head);
            title = (TextView) itemView.findViewById(R.id.tv_nearby_bb_item_title);
            distance = (TextView) itemView.findViewById(R.id.tv_nearby_bb_item_distance_content);
            time = (TextView) itemView.findViewById(R.id.tv_nearby_bb_item_time_content);
            position = (TextView) itemView.findViewById(R.id.tv_nearby_bb_item_position_content);
            btn= (Button) itemView.findViewById(R.id.btn_nearby_bb_item);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(itemClickListener!=null)
                        itemClickListener.click(info_id,getAdapterPosition());
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(itemClickListener!=null)
                        itemClickListener.click(info_id,getAdapterPosition());
                }
            });
        }
        public void bind(int pos){
            info_id=mList.get(pos).getInfo_id();
            head.setImageBitmap(BitmapFactory.decodeFile(mList.get(pos).getUser_head()));
            title.setText(mList.get(pos).getTitle());
            distance.setText(mList.get(pos).getDistance());
            time.setText(mList.get(pos).getTime());
            position.setText(mList.get(pos).getPosition());
        }
    }

    class FootViewHolder extends ViewHolder {
        public FootViewHolder(View view) {
            super(view);
        }
    }
}

