import React from "react";
import { render, screen } from "@testing-library/react";
import "@testing-library/jest-dom/extend-expect";


import Vacina from "../../pages/Vacina/Create";
import Header from "../../components/Header";

describe("Testing Vacina.js", () => {
  // Deve ser possível exibir o elemento h1 na página
  it("should be able to show the h1 element", () => {
    render(<Vacina />);
    const h1Element = screen.getByText(/cadastrar nova vacina/i);

    expect(h1Element).toBeInTheDocument();
  });
});