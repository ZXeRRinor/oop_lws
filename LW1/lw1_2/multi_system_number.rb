class MultiSystemNumber
  def initialize(number = nil, system_base = 10, raw_number = nil)
    @number = number
    @raw_number = raw_number ? raw_number : @number.to_s.split('')
    @system_base = system_base
  end

  def to_i
    result = 0
    @raw_number.reverse.each_with_index do |elem, index|
      result += elem.to_i * @system_base ** index.to_i
    end
    result
  end

  def from_dec_to(system_base, number = @number) #returns raw number
    if number != 0
      result = []
      res = number
      while res != 0
        result.push(res % system_base)
        res = (res - res % system_base) / system_base
      end
      result.reverse
    else
      [0]
    end
  end

  def from_dec_to!(system_base)
    @raw_number = from_dec_to(system_base)
    @number = nil
    @system_base = system_base
  end

  def to_system(system_base)
    self.from_dec_to(system_base, to_i)
  end

  def to_system!(system_base)
    @number = self.from_dec_to(system_base, to_i)
    @system_base = system_base
  end
end