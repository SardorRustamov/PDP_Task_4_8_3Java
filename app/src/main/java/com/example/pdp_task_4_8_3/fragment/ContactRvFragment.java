package com.example.pdp_task_4_8_3.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pdp_task_4_8_3.adapter.ContactAdapter;
import com.example.pdp_task_4_8_3.databinding.FragmentContactRvBinding;
import com.example.pdp_task_4_8_3.model.ContactList;

import java.util.ArrayList;
import java.util.List;

public class ContactRvFragment extends Fragment {

    public ContactRvFragment() {
        // Required empty public constructor
    }

    private FragmentContactRvBinding binding;
    private List<ContactList> list;
    FirstFragmentListener fragmentListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContactRvBinding.inflate(inflater, container, false);
        loadData();

        ContactAdapter adapter = new ContactAdapter(list, new ContactAdapter.OnItemClick() {
            @Override
            public void onClickListener(ContactList contactList) {
                fragmentListener.onSendContact(contactList);
            }
        });
                binding.rv.setAdapter(adapter);

        return binding.getRoot();
    }

    private void loadData() {
        list  = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            list.add(new ContactList("Alisher", "+998 99 997 99 99"));
            list.add(new ContactList("Jasur", "+998 90 000 09 00"));
            list.add(new ContactList("Anvar", "+998 97 777 77 77"));
            list.add(new ContactList("Sanjar", "+998 95 500 00 07"));
            list.add(new ContactList("Jalol", "+998 97 700 00 00"));
        }
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FirstFragmentListener){
            fragmentListener = (FirstFragmentListener) context;
        } else {
            throw  new RuntimeException(context + "Error");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentListener = null;
    }

    public interface FirstFragmentListener{
        void onSendContact(ContactList contactList);
    }
}