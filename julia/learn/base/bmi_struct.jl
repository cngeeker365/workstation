mutable struct Person
    height
    weight
    bmi
    class
end

people = Set{Person}()

for i = 1:1000
    h = rand()*(1.8-1.5)+1.5
    w = rand()*(100-30)+30
    p = Person(h,w,0,0)
    push!(people, p)
end

function bmi_category(index::Float64)
    class = 0
    if index < 18.5
        class = 1
    elseif index < 24
        class = 2
    elseif index < 28
        class =3
    elseif index < 30
        class = 4
    elseif index < 40
        class = 5
    else 
        class = 6
    end

    class
end

function bmi(p::Person)
    p.bmi = p.weight/(p.height^2)
    p.class = bmi_category(p.bmi)
end

categories = Dict()
for p ∈ people
    bmi(p)
    categories[p.class] = get(categories, p.class, 0) +1
end

println(categories)              