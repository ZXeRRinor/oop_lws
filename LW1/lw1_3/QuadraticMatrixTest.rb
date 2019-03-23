require_relative 'quadratic_matrix'

def generate_output_message(lm, name)
  test_result = ""
  condition = lm.()
  if condition
    test_result = " test passed"
  else
    test_result = " test failed"
  end
  "-" + name + test_result
end

def test_degenerate_matrix_determinant
  quad_mtrx = QuadraticMatrix.new([[1, 2, 3],
                                   [4, 5, 6],
                                   [7, 8, 9]
                                  ])
  puts(generate_output_message(lambda {quad_mtrx.calculate_determinant == 0}, "Degenerate matrix determinant"))
end

def test_degenerate_matrix_inverse_matrix
  quad_mtrx = QuadraticMatrix.new([[1, 2, 3],
                                   [4, 5, 6],
                                   [7, 8, 9]
                                  ])
  puts(generate_output_message(lambda {quad_mtrx.get_reverse_matrix == nil}, "Degenerate matrix inverse matrix"))
end

def test_degenerate_matrix_have_inverse_matrix
  quad_mtrx = QuadraticMatrix.new([[1, 2, 3],
                                   [4, 5, 6],
                                   [7, 8, 9]
                                  ])
  puts(generate_output_message(lambda {!quad_mtrx.have_inverse_matrix?}, "Degenerate matrix have inverse matrix"))
end

def test_matrix
  quad_mtrx = QuadraticMatrix.new([[1, 0, 5],
                                   [0, 1, -9],
                                   [0, 0, 1]
                                  ])
  puts(generate_output_message(lambda {quad_mtrx.get_reverse_matrix.to_a == [[1, 0, -5],
                                                                             [0, 1, 9],
                                                                             [0, 0, 1]
  ]}, "Inverse matrix"))
end

def test_matrix_have_inverse_matrix
  quad_mtrx = QuadraticMatrix.new([[1, 2, 3],
                                   [4, 5, 6],
                                   [7, 8, 9]
                                  ])
  puts(generate_output_message(lambda {!quad_mtrx.have_inverse_matrix?}, "Matrix have inverse matrix"))
end

def test_matrix_multiplying_by_number
  quad_mtrx = QuadraticMatrix.new([[1, 2, 3],
                                   [4, 5, 6],
                                   [7, 8, 9]
                                  ])
  puts(generate_output_message(lambda {quad_mtrx.multiply_by_number(2).to_a == [
      [2, 4, 6],
      [8, 10, 12],
      [14, 16, 18]
  ]}, "Matrix multiplying by number"))
end

def test_matrix_transpose
  quad_mtrx = QuadraticMatrix.new([[1, 2, 3],
                                   [4, 5, 6],
                                   [7, 8, 9]
                                  ])
  puts(generate_output_message(lambda {quad_mtrx.transpose.to_a == [
      [1, 4, 7],
      [2, 5, 8],
      [3, 6, 9]
  ]}, "Matrix transposing"))
end


test_degenerate_matrix_determinant
test_degenerate_matrix_have_inverse_matrix
test_matrix
test_degenerate_matrix_inverse_matrix
test_matrix_have_inverse_matrix
test_matrix_multiplying_by_number
test_matrix_transpose