class QuadraticMatrix

  attr_reader :determinant

  def initialize(matrix)
    if matrix.class != Array
      raise ArgumentError, "it's not an array"
    end
    line_length = matrix[0].length
    matrix.each do |line|
      unless line.length == line_length
        raise ArgumentError, "matrix must contain lines with equal length"
      end
    end
    unless matrix.length == line_length
      raise ArgumentError, "matrix must be quadratic"
    end
    @matrix = matrix
    @determinant = nil
  end

  def to_a
    @matrix
  end

  def transpose
    length = @matrix.length
    matrix = @matrix.map(&:dup)
    (0...length).each do |j|
      (0...length).each do |i|
        matrix[j][i] = @matrix[i][j]
      end
    end
    QuadraticMatrix.new(matrix)
  end

  def calculate_minor_matrix
    length = @matrix.length
    minor_matrix = []
    (0...length).each do |j|
      minor_matrix.push([])
      (0...length).each do |i|
        matrix = @matrix.map(&:dup)
        matrix.delete_at(j)
        matrix.each {|row| row.delete_at(i)}
        if matrix.length == 1
          minor_matrix[j][i] = matrix[0][0]
        else
          minor_matrix[j][i] = QuadraticMatrix.new(matrix).calculate_determinant
        end
      end
    end
    QuadraticMatrix.new(minor_matrix)
  end

  def calculate_cofactor_matrix
    length = @matrix.length
    cofactor_matrix = []
    minor_matrix = calculate_minor_matrix.to_a
    (0...length).each do |j|
      cofactor_matrix.push([])
      (0...length).each do |i|
        cofactor_matrix[j][i] = minor_matrix[j][i] * ((i + j) % 2 == 0 ? 1 : -1)
      end
    end
    QuadraticMatrix.new(cofactor_matrix)
  end

  def calculate_determinant
    determinant = 0
    if @determinant.nil?
      if self.get_size == [2, 2]
        determinant = @matrix[0][0] * @matrix[1][1] - @matrix[1][0] * @matrix[0][1]
      else
        calculate_cofactor_matrix.to_a.first.each_with_index do |elem, index|
          determinant += elem * @matrix.first[index]
        end
      end
      @determinant = determinant
    else
      @determinant
    end
  end

  def multiply_by_number(num)
    #matrix = @matrix.map(&:dup)
    matrix = @matrix.map do |line|
      line.map {|elem| elem * num}
    end
    QuadraticMatrix.new(matrix)
  end

  def get_reverse_matrix
    if have_inverse_matrix?
      calculate_cofactor_matrix.transpose.multiply_by_number(1 / calculate_determinant)
    end
  end

  def have_inverse_matrix?
    calculate_determinant != 0
  end

  def get_size
    [@matrix[0].length, @matrix.length]
  end
end