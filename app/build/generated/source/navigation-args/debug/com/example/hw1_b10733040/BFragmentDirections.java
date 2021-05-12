package com.example.hw1_b10733040;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class BFragmentDirections {
  private BFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionBFragmentToAFragment() {
    return new ActionOnlyNavDirections(R.id.action_BFragment_to_AFragment);
  }
}
