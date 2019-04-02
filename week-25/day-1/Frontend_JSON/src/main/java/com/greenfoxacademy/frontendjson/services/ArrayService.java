package com.greenfoxacademy.frontendjson.services;

import com.greenfoxacademy.frontendjson.models.MyError;
import com.greenfoxacademy.frontendjson.models.Result;
import com.greenfoxacademy.frontendjson.models.ResultArray;
import org.springframework.stereotype.Service;

@Service
public class ArrayService {

  public Object handleArray(String action, int[] numbers) {
    if (action.equals("sum")) {
      return sumElements(numbers);
    } else if (action.equals("multiply")) {
      return multipyElements(numbers);
    } else if (action.equals("double")) {
      return doubleElements(numbers);
    }
    return new MyError("Please provide a valid operation to perform!");
  }

  private Result sumElements(int[] numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return new Result(sum);
  }

  private Result multipyElements(int[] numbers) {
    int product = 1;
    for (int number : numbers) {
      product *= number;
    }
    return new Result(product);
  }

  private ResultArray doubleElements(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] *= 2;
    }
    return new ResultArray(numbers);
  }

}
