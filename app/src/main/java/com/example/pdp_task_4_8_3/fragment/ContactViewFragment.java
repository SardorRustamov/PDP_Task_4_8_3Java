package com.example.pdp_task_4_8_3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pdp_task_4_8_3.R;
import com.example.pdp_task_4_8_3.databinding.FragmentContactViewBinding;
import com.example.pdp_task_4_8_3.model.ContactList;

public class ContactViewFragment extends Fragment {

    public ContactViewFragment() {
        // Required empty public constructor
    }
    FragmentContactViewBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding= FragmentContactViewBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void updateContactFragment(ContactList contactList){
        binding.name.setText(contactList.getName());
        binding.phone.setText(contactList.getPhone());
    }

}