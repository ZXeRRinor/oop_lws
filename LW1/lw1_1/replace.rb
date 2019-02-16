begin
  puts('you have to input next arguments after "ruby replace.rb": <input file> <output file> <search string> <replacement string>')
  if ARGV.length != 4
    raise(ArgumentError, 'Invalid number of arguments.')
  else
    input_file_name, output_file_name, search_string, replace_string = ARGV
    if search_string == ''
      raise(ArgumentError, 'Blank search string')
    end
  end

  File.open(input_file_name, 'r') do |in_file|
    File.open(output_file_name, 'w+') do |out_file|
      while str = in_file.gets
        out_file.puts(str.chomp.gsub(Regexp.new(search_string), replace_string))
      end
    end
  end

rescue ArgumentError => errMsg
  puts(errMsg)
rescue Errno::ENOENT => errMsg
  puts(errMsg)
end