require_relative 'multi_system_number'

ALPHABET = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('')
ALPHABET_REGEXP = /[A-Za-z]/

source_notation = ARGV[0].to_i
destination_notation = ARGV[1].to_i
value = ARGV[2]

if value =~ ALPHABET_REGEXP
  raw_number = value.split('').map {|sym| sym =~ ALPHABET_REGEXP ? ALPHABET.index(sym) + 10 : sym.to_i}
  number = MultiSystemNumber.new(nil, source_notation, raw_number)
else
  number = MultiSystemNumber.new(value, source_notation)
end
result_number = number.to_system(destination_notation)
puts value[0] == '-' ? result_number.unshift('-').join : result_number.join