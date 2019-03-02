require_relative 'quadratic_matrix'

def read_matrix_from_file(filename, splitter)
  matrix = []
  lines = []
  File.open(filename, 'r') do |f|
    lines = f.readlines
  end
  lines.each do |line|
    matrix.push(line.chomp.split(splitter).map(&:to_i))
  end
  matrix
end

begin
  if ARGV.length != 1
    raise(ArgumentError, "Invalid number of arguments.")
  else
    filename = ARGV.first
  end

  QuadraticMatrix.new(read_matrix_from_file(filename, ' ')).get_reverse_matrix.to_a.each(&method(:p))

rescue ArgumentError => errMsg
  puts(errMsg)
  puts('You have to input next arguments after "ruby invert.rb": <name of input file>')
end