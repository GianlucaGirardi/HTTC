// __tests__/Hello.test.tsx
import React from "react";
import { render } from "@testing-library/react-native";
import { Hello } from "../Hello";

describe("Hello component", () => {
  it("renders the correct text", () => {
    const { getByText } = render(<Hello />);
    expect(getByText("Hello, Luca!")).toBeTruthy();
  });
});
