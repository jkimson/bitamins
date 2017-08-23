package bitamins.bmwaresd.apps.bitamins;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Contacts object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        ContactHolder contactHolder;
        if(row == null)
        {
            LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent, false);
            contactHolder = new ContactHolder();
            contactHolder.a1 = (TextView)row.findViewById(R.id.a1);
            contactHolder.a2= (TextView)row.findViewById(R.id.a2);
            contactHolder.a3 = (TextView)row.findViewById(R.id.a3);
            contactHolder.a4 = (TextView)row.findViewById(R.id.a4);
            row.setTag(contactHolder);

        }
        else
        {
            contactHolder= (ContactHolder)row.getTag();
        }
        Contacts contacts = (Contacts)this.getItem(position);
        contactHolder.a1.setText(contacts.getId());

        contactHolder.a2.setText(contacts.getName());
        contactHolder.a3.setText(contacts.getDescription());
        contactHolder.a4.setText(contacts.getDate());
        return row;
    }

    static class ContactHolder
    {
        TextView a1,a2,a3,a4;
    }
}
