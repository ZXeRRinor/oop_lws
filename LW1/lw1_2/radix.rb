require_relative 'multi_system_number'

ALPHABET = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('')
ALPHABET_REGEXP = /[A-Za-z]/

def radix(source_notation, destination_notation, value)
  if value =~ ALPHABET_REGEXP
    raw_number = value.split('').map {|sym| sym =~ ALPHABET_REGEXP ? ALPHABET.index(sym) + 10 : sym.to_i}
    number = MultiSystemNumber.new(nil, source_notation, raw_number)
  else
    number = MultiSystemNumber.new(value, source_notation)
  end
  result_number = number.to_system(destination_notation).map do |num_digit|
    num_digit > 9 ? ALPHABET[num_digit - 10] : num_digit
  end
  value[0] == '-' ? result_number.unshift('-').join : result_number.join
end

begin
  if ARGV.length != 3
    raise(ArgumentError, 'Invalid number of arguments.')
  else
    source_notation, destination_notation, value = ARGV
  end

  puts(radix(source_notation.to_i, destination_notation.to_i, value))

rescue ArgumentError => errMsg
  puts(errMsg)
  puts('You have to input next arguments after "ruby radix.rb": <source notation> <destination notation> <value>')
end