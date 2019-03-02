class QuadraticMatrix

  attr_reader :matrix, :determinant

  def initialize(matrix)
    if matrix.class != Array
      raise ArgumentError, "it's not an array"
    end
    line_length = matrix[0].length
    matrix.each do |line|
      unless line.length == line_length
        raise ArgumentError, "matrix have to contain lines with equal length"
      end
    end
    @matrix = matrix
    @determinant = nil
  end

  def can_calculate_determinant?
    size = get_size
    size[0] == size[1]
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
        minor_matrix[j][i] = QuadraticMatrix.new(matrix).calculate_determinant
      end
    end
    minor_matrix
  end

  def calculate_cofactor_matrix
    length = @matrix.length
    cofactor_matrix = []
    minor_matrix = calculate_minor_matrix
    (0...length).each do |j|
      cofactor_matrix.push([])
      (0...length).each do |i|
        cofactor_matrix[j][i] = minor_matrix[j][i] * @matrix[j][i] * ((i + j) % 2 == 0 ? 1 : -1)
      end
    end
    cofactor_matrix
  end

  def calculate_determinant
    unless can_calculate_determinant?
      raise ArgumentError, "can't calculate determinant"
    end
    determinant = 0
    if self.get_size == [2, 2]
      determinant = @matrix[0][0] * @matrix[1][1] - @matrix[1][0] * @matrix[0][1]
    else
      calculate_cofactor_matrix.first.each {|elem| determinant += elem}
    end
    @determinant = determinant
  end

  def have_inverse_matrix?
    calculate_determinant != 0
  end

  def get_size
    [@matrix[0].length, @matrix.length]
  end
end