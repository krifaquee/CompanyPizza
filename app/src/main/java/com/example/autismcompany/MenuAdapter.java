package com.example.autismcompany;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autismcompany.R;
import com.example.autismcompany.MenuItemModel;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<MenuItemModel> menuItems;

    // Конструктор адаптера принимает список пунктов
    public MenuAdapter(List<MenuItemModel> menuItems) {
        this.menuItems = menuItems;
    }

    // Создаём новый ViewHolder (объект-строку)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // "Надуваем" layout menu_item.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(view);
    }

    // Привязываем данные к элементам интерфейса
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuItemModel item = menuItems.get(position);
        holder.itemTitle.setText(item.getTitle());
        holder.itemPrice.setText("Цена: " + item.getPrice() + " BYN");
        holder.itemDescription.setText(item.getDescription());
        holder.itemImage.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    // ViewHolder хранит ссылки на виджеты одного элемента списка
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemTitle, itemPrice, itemDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemDescription = itemView.findViewById(R.id.item_description);

            // Если нужно обработать клик на всю карточку:
            // itemView.setOnClickListener(v -> { ... });
        }
    }
}
