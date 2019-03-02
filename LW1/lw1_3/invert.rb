require_relative 'quadratic_matrix'

matrix1 = QuadraticMatrix.new([
                                [1, 5, 3],
                                [2, 4, 7],
                                [4, 6, 2]
                            ])

p matrix1.calculate_determinant
p matrix1.transpose.matrix
p matrix1.multiply_by_number(0.5).matrix