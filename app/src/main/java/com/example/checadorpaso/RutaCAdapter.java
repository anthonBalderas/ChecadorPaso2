package com.example.checadorpaso;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RutaCAdapter extends RecyclerView.Adapter<RutaCAdapter.viewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public RutaCAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }
    public class viewHolder extends RecyclerView.ViewHolder {

        private TextView horaText,rutaText,unidadText;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            unidadText = itemView.findViewById(R.id.textview_unidad_item);
            rutaText = itemView.findViewById(R.id.textview_ruta_item);
            horaText = itemView.findViewById(R.id.textview_hora_item);

        }
    }


    @NonNull
    @Override
    public RutaCAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.registro_c_list, parent, false);
        return new viewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RutaCAdapter.viewHolder holder, int position) {

        if (!mCursor.moveToPosition(position)) {
            return;
        }

            String ruta = mCursor.getString(mCursor.getColumnIndex(UnidadesContract.UnidadesEntry3.COLUMN_RUTA));
            String unidad = mCursor.getString(mCursor.getColumnIndex(UnidadesContract.UnidadesEntry3.COLUMN_UNIDAD));
            String hora = mCursor.getString(mCursor.getColumnIndex(UnidadesContract.UnidadesEntry3.COLUMN_HORA));
            long id = mCursor.getLong(mCursor.getColumnIndex(UnidadesContract.UnidadesEntry3._ID));

        holder.rutaText.setText(ruta);
        holder.unidadText.setText(unidad);
        holder.horaText.setText(hora);
        holder.itemView.setTag(id);


    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }
        mCursor = newCursor;
        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}
