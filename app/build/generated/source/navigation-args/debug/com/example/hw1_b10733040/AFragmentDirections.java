package com.example.hw1_b10733040;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class AFragmentDirections {
  private AFragmentDirections() {
  }

  @NonNull
  public static ActionAFragmentToBFragment actionAFragmentToBFragment() {
    return new ActionAFragmentToBFragment();
  }

  public static class ActionAFragmentToBFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionAFragmentToBFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionAFragmentToBFragment setMessage(@NonNull String message) {
      if (message == null) {
        throw new IllegalArgumentException("Argument \"message\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("message", message);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionAFragmentToBFragment setMessage2(@NonNull String message2) {
      if (message2 == null) {
        throw new IllegalArgumentException("Argument \"message2\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("message2", message2);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionAFragmentToBFragment setMessage3(@NonNull String message3) {
      if (message3 == null) {
        throw new IllegalArgumentException("Argument \"message3\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("message3", message3);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionAFragmentToBFragment setMessage4(@NonNull String message4) {
      if (message4 == null) {
        throw new IllegalArgumentException("Argument \"message4\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("message4", message4);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("message")) {
        String message = (String) arguments.get("message");
        __result.putString("message", message);
      } else {
        __result.putString("message", "123");
      }
      if (arguments.containsKey("message2")) {
        String message2 = (String) arguments.get("message2");
        __result.putString("message2", message2);
      } else {
        __result.putString("message2", "123");
      }
      if (arguments.containsKey("message3")) {
        String message3 = (String) arguments.get("message3");
        __result.putString("message3", message3);
      } else {
        __result.putString("message3", "123");
      }
      if (arguments.containsKey("message4")) {
        String message4 = (String) arguments.get("message4");
        __result.putString("message4", message4);
      } else {
        __result.putString("message4", "123");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_AFragment_to_BFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getMessage() {
      return (String) arguments.get("message");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getMessage2() {
      return (String) arguments.get("message2");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getMessage3() {
      return (String) arguments.get("message3");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getMessage4() {
      return (String) arguments.get("message4");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionAFragmentToBFragment that = (ActionAFragmentToBFragment) object;
      if (arguments.containsKey("message") != that.arguments.containsKey("message")) {
        return false;
      }
      if (getMessage() != null ? !getMessage().equals(that.getMessage()) : that.getMessage() != null) {
        return false;
      }
      if (arguments.containsKey("message2") != that.arguments.containsKey("message2")) {
        return false;
      }
      if (getMessage2() != null ? !getMessage2().equals(that.getMessage2()) : that.getMessage2() != null) {
        return false;
      }
      if (arguments.containsKey("message3") != that.arguments.containsKey("message3")) {
        return false;
      }
      if (getMessage3() != null ? !getMessage3().equals(that.getMessage3()) : that.getMessage3() != null) {
        return false;
      }
      if (arguments.containsKey("message4") != that.arguments.containsKey("message4")) {
        return false;
      }
      if (getMessage4() != null ? !getMessage4().equals(that.getMessage4()) : that.getMessage4() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
      result = 31 * result + (getMessage2() != null ? getMessage2().hashCode() : 0);
      result = 31 * result + (getMessage3() != null ? getMessage3().hashCode() : 0);
      result = 31 * result + (getMessage4() != null ? getMessage4().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionAFragmentToBFragment(actionId=" + getActionId() + "){"
          + "message=" + getMessage()
          + ", message2=" + getMessage2()
          + ", message3=" + getMessage3()
          + ", message4=" + getMessage4()
          + "}";
    }
  }
}
